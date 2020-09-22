package com.zhuyc.spring.ioc.overview.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname Super
 * @PackageName com.zhuyc.spring.ioc.overview.annotation
 * @Date 2020/9/21 16:19
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {
}
