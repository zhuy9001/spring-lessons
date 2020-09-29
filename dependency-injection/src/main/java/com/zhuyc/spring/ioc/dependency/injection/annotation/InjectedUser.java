package com.zhuyc.spring.ioc.dependency.injection.annotation;

import java.lang.annotation.*;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname InjectedUser
 * @PackageName com.zhuyc.spring.ioc.dependency.injection.annotation
 * @Date 2020/9/28 15:09
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface InjectedUser {
}
