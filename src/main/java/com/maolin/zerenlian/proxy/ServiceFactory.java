package com.maolin.zerenlian.proxy;

import com.maolin.zerenlian.annotation.BizService;
import com.maolin.zerenlian.annotation.ParamsHandle;
import com.maolin.zerenlian.handle.BaseParamsHandle;
import com.maolin.zerenlian.model.BizRequest;
import com.maolin.zerenlian.util.ClassUtil;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-07-16 09:29
 */
public class ServiceFactory {

    private ServiceFactory() {
        objectMap = new ConcurrentHashMap<>();
    }

    private Map<String, Object> objectMap;


    private static volatile ServiceFactory factory;

    public static ServiceFactory getInstance() {
        if (factory == null) {
            synchronized (ServiceFactory.class) {
                if (factory == null) {
                    factory = new ServiceFactory();
                }
            }
        }
        return factory;
    }

    /**
     * 创建api接口
     * https://www.cnblogs.com/heaveneleven/p/9125228.html
     * https://www.cnblogs.com/wangzhen-fly/p/11002814.html 获取所有接口的实现类
     * https://www.jianshu.com/p/7601ba434ff4 ServiceLoader
     *
     * @param clazz api接口类
     * @param <T>   接口泛型
     * @return 接口代理类
     */
    @SuppressWarnings("Unchecked")
    public synchronized <T> T createApi(Class<T> clazz) {
        if (!clazz.isInterface()) {
            throw new RuntimeException("错误的api类型");
        }
        //首先从缓存中查找
        String clazzKey = clazz.getName();
        Object obj = objectMap.get(clazzKey);
        if (obj != null) {
            return (T) obj;
        }
        //获取接口的所有实现类
        List<Class<T>> classList = ClassUtil.getAllClassByInterface(clazz);
        if (classList == null || classList.size() == 0) {
            throw new RuntimeException("该接口没有实现类");
        }
        Class<T> annoClazz = null;
        for (Class<T> clz : classList) {
            BizService bizService = clz.getDeclaredAnnotation(BizService.class);
            if (bizService == null) {
                continue;
            }
            annoClazz = clz;
            break;
        }
        if (annoClazz == null) {
            throw new RuntimeException("该接口的实现类没有BizService注解");
        }

        ClassLoader classLoader = clazz.getClassLoader();
        Class<?>[] interfaces = new Class[]{clazz};

        try {
            T t = annoClazz.newInstance();
            Object proxyInstance = Proxy.newProxyInstance(classLoader, interfaces, (proxy, method, args) -> {
                Class[] clazzType = new Class[args.length];
                for (int i = 0; i < args.length; i++) {
                    clazzType[i] = args[i].getClass();
                }
                Method implMethod = t.getClass().getMethod(method.getName(), clazzType);
                ParamsHandle[] paramsHandles = implMethod.getAnnotationsByType(ParamsHandle.class);
                processParamsHandle(paramsHandles, args);
                return method.invoke(t, args);
            });
            objectMap.put(clazzKey, proxyInstance);
            return (T) proxyInstance;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void processParamsHandle(ParamsHandle[] paramsHandle, Object[] args) throws IllegalAccessException, InstantiationException {
        if (paramsHandle == null || paramsHandle.length == 0) {
            return;
        }

        List<ParamsHandle> paramsHandleList = Arrays.stream(paramsHandle).sorted(Comparator.comparingInt(ParamsHandle::index)).collect(Collectors.toList());

        BaseParamsHandle first = null;
        BaseParamsHandle next = null;
        for (ParamsHandle handle : paramsHandleList) {
            Class<? extends BaseParamsHandle> clazz = handle.clazz();
            BaseParamsHandle instance = clazz.newInstance();
            if (first == null) {
                first = instance;
            } else if (next == null) {
                first.setBaseParamsHandle(instance);
                next = instance;
            } else {
                next.setBaseParamsHandle(instance);
                next = instance;
            }
        }
        first.process((BizRequest) args[0]);
    }
}
