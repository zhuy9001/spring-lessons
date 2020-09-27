package com.zhuyc.spring.ioc.dependency.injection.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname UserGroup
 * @PackageName com.zhuyc.spring.ioc.dependency.injection.annotation
 * @Date 2020/9/27 14:57
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier
public @interface UserGroup {

}
