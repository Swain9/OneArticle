package com.maolin.zerenlian.annotation;

import com.maolin.zerenlian.handle.BaseParamsHandle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <PRE>
 * 参数注解
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-07-16 09:11
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ParamsHandleContainer.class)
public @interface ParamsHandle {
    /**
     * 注解处理参数的实现类
     *
     * @return 参数注解的子类实现对象
     */
    Class<? extends BaseParamsHandle> clazz();

    /**
     * 标记当前实现的序号
     *
     * @return 序号
     */
    int index() default 0;
}
