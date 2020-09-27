package com.zhuyc.spring.ioc.dependency.injection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhuyc
 * @Description 基于 {@link org.springframework.beans.factory.Aware}接口回调的依赖注入示例
 * @Classname AutoWiringByNameDependencySetterInjectionDemo
 * @PackageName com.zhuyc.spring.ioc.dependency.injection
 * @Date 2020/9/24 16:56
 */
public class AwareInterfaceDependencyInjectionDemo implements BeanFactoryAware , ApplicationContextAware {

	private static BeanFactory beanFactory;

	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(AwareInterfaceDependencyInjectionDemo.class);

		applicationContext.refresh();
		UserHolder userHolder=applicationContext.getBean(UserHolder.class);
		System.out.println(userHolder);

		applicationContext.close();
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		AwareInterfaceDependencyInjectionDemo.beanFactory=beanFactory;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		AwareInterfaceDependencyInjectionDemo.applicationContext=applicationContext;
	}
}
