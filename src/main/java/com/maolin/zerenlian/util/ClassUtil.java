package com.maolin.zerenlian.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * <PRE>
 * 获取接口的所有实现类 理论上也可以用来获取类的所有子类
 * 查询路径有限制，只局限于接口所在模块下，比如pandora-gateway,而非整个pandora（会递归搜索该文件夹下所以的实现类）
 * 路径中不可含中文，否则会异常。若要支持中文路径，需对该模块代码中url.getPath() 返回值进行urldecode.
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-07-16 09:56
 */
public class ClassUtil {
    private static final Logger LOG = LoggerFactory.getLogger(ClassUtil.class);

    /**
     * 获取接口的所有实现类
     *
     * @param clazz 接口对象
     * @return 获取接口的实现类
     */
    public static <T> List<Class<T>> getAllClassByInterface(Class<T> clazz) {
        List<Class<T>> list = new ArrayList<>();
        // 判断是否是一个接口
        if (clazz.isInterface()) {
            try {
                List<Class> allClass = getAllClass(clazz.getPackage().getName());
                /*
                 * 循环判断路径下的所有类是否实现了指定的接口 并且排除接口类自己
                 */
                for (Class clz : allClass) {
                    /*
                     * 判断是不是同一个接口
                     */
                    // isAssignableFrom:判定此 Class 对象所表示的类或接口与指定的 Class
                    // 参数所表示的类或接口是否相同，或是否是其超类或超接口
                    if (clazz.isAssignableFrom(clz)) {
                        if (!clazz.equals(clz)) {
                            // 自身并不加进去
                            list.add(clz);
                        }
                    }
                }
            } catch (Exception e) {
                LOG.error("出现异常{}", e.getMessage());
                throw new RuntimeException("出现异常" + e.getMessage());
            }
        }
        LOG.info("加载的有效类列表数量 :" + list.size());
        return list;
    }


    /**
     * 从一个指定路径下查找所有的类
     *
     * @param packageName 包名
     */
    private static List<Class> getAllClass(String packageName) {


        LOG.info("要搜索的包名：" + packageName);
        List<String> classNameList = getClassName(packageName);
        List<Class> list = new ArrayList<>();

        for (String className : classNameList) {
            try {
                list.add(Class.forName(className));
            } catch (ClassNotFoundException e) {
                LOG.error("从名称加载类失败:" + className + e.getMessage());
                throw new RuntimeException("从名称加载类失败:" + className + e.getMessage());
            }
        }
        LOG.info("加载的类列表数量 :" + list.size());
        return list;
    }

    /**
     * 获取某包下所有类
     *
     * @param packageName 包名
     * @return 类的完整名称
     */
    public static List<String> getClassName(String packageName) {

        List<String> fileNames = null;
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String packagePath = packageName.replace(".", "/");
        URL url = loader.getResource(packagePath);
        if (url != null) {
            String type = url.getProtocol();
            LOG.debug("协议类型 : " + type);
            if ("file".equals(type)) {
                String fileSearchPath = url.getPath();
                LOG.debug("搜索路径: " + fileSearchPath);
                //只搜索当前目录, 不搜索jar包
                //fileSearchPath = fileSearchPath.substring(0, fileSearchPath.indexOf("/classes"));
                //LOG.debug("搜索路径: " + fileSearchPath);
                fileNames = getClassNameByFile(fileSearchPath);
            } else if ("jar".equals(type)) {
                try {
                    JarURLConnection connection = (JarURLConnection) url.openConnection();
                    JarFile jarFile = connection.getJarFile();
                    fileNames = getClassNameByJar(jarFile, packagePath);
                } catch (java.io.IOException e) {
                    throw new RuntimeException("打开jar包失败：" + e.getMessage());
                }

            } else {
                throw new RuntimeException("文件系统不支持,无法加载");
            }
        }
        return fileNames;
    }

    /**
     * 从项目文件获取某包下所有类
     *
     * @param filePath 文件路径
     * @return 类的完整名称
     */
    private static List<String> getClassNameByFile(String filePath) {
        List<String> myClassName = new ArrayList<>();
        File file = new File(filePath);
        File[] childFiles = file.listFiles();
        if (childFiles == null) {
            return myClassName;
        }
        for (File childFile : childFiles) {
            if (childFile.isDirectory()) {
                myClassName.addAll(getClassNameByFile(childFile.getPath()));
            } else {
                String childFilePath = childFile.getPath();
                if (childFilePath.endsWith(".class")) {
                    childFilePath = childFilePath.substring(childFilePath.indexOf("\\classes") + 9, childFilePath.lastIndexOf("."));
                    childFilePath = childFilePath.replace("\\", ".");
                    myClassName.add(childFilePath);
                }
            }
        }
        return myClassName;
    }

    /**
     * 从jar获取某包下所有类
     *
     * @return 类的完整名称
     */
    private static List<String> getClassNameByJar(JarFile jarFile, String packagePath) {
        List<String> myClassName = new ArrayList<>();
        try {
            Enumeration<JarEntry> entrys = jarFile.entries();
            while (entrys.hasMoreElements()) {
                JarEntry jarEntry = entrys.nextElement();
                String entryName = jarEntry.getName();
                if (entryName.endsWith(".class")) {
                    entryName = entryName
                            .replace("/", ".")
                            .substring(0, entryName.lastIndexOf("."));
                    myClassName.add(entryName);
                }
            }
        } catch (Exception e) {
            LOG.error("发生异常:" + e.getMessage());
            throw new RuntimeException("发生异常:" + e.getMessage());
        }
        return myClassName;
    }
}
