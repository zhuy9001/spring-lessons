package com.zhuyc.spring.ioc.dependency.injection.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.*;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname MyAutowired
 * @PackageName com.zhuyc.spring.ioc.dependency.injection.annotation
 * @Date 2020/9/28 15:06
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Autowired
public @interface MyAutowired {
	boolean required() default true;
}
