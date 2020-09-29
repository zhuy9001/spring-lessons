package com.zhuyc.spring.ioc.dependency.injection;

import com.zhuyc.spring.ioc.dependency.injection.annotation.InjectedUser;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname InjectUserAnnotationBeanPostProcessor
 * @PackageName com.zhuyc.spring.ioc.dependency.injection
 * @Date 2020/9/28 15:20
 */
public class InjectUserAnnotationBeanPostProcessor extends AutowiredAnnotationBeanPostProcessor {

	public InjectUserAnnotationBeanPostProcessor() {
		this.setAutowiredAnnotationType(InjectedUser.class);
	}
}
