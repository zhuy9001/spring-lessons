package com.zhuyc.spring.dependency.lookup;

import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname TypeSafetyDependencyLookupDemo
 * @PackageName com.zhuyc.spring.dependency.lookup
 * @Date 2020/9/24 9:36
 */
public class TypeSafetyDependencyLookupDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		//注册	configuration配置类
		applicationContext.register(ObjectProviderDemo.class);
		//启动应用上下文
		applicationContext.refresh();

		//演示 BeanFactory#getBean 方法的安全性
		displayBeanFactoryGetBean(applicationContext);

		//演示 BeanFactory#getObject 方法的安全性
		displayObjectFactoryGetObject(applicationContext);

		//演示 ObjectProvider#getIfAvailable 方法的安全性
		displayObjectProviderIfAvailable(applicationContext);
		//演示 ListableBeanFactory#getBeanOfType 方法的安全性
		displayListableBeanFactoryGetBeanOfType(applicationContext);
		//演示 ObjectProvider#Stream 方法的安全性
		displayObjectProviderStreamOps(applicationContext);

		//关闭应用上下文
		applicationContext.close();
	}

	private static void displayObjectProviderStreamOps(AnnotationConfigApplicationContext applicationContext) {
		ObjectProvider<User> userObjectProvider=applicationContext.getBeanProvider(User.class);
		printBeansException("displayObjectProviderStreamOps",()->userObjectProvider.stream().forEach(System.out::println));
	}

	private static void displayListableBeanFactoryGetBeanOfType(ListableBeanFactory beanFactory) {
		printBeansException("displayListableBeanFactoryGetBeanOfType",()->beanFactory.getBeansOfType(User.class));
	}

	private static void displayObjectProviderIfAvailable(AnnotationConfigApplicationContext applicationContext) {
		ObjectProvider<User> userObjectProvider=applicationContext.getBeanProvider(User.class);
		printBeansException("displayBeanProviderIfAvailable",()->userObjectProvider.getIfAvailable());
	}


	private static void displayObjectFactoryGetObject(AnnotationConfigApplicationContext applicationContext) {
		ObjectFactory<User> userObjectProvider=applicationContext.getBeanProvider(User.class);
		printBeansException("displayBeanFactoryGetObject",()->userObjectProvider.getObject());
	}

	public static void displayBeanFactoryGetBean(BeanFactory beanFactory) {
		printBeansException("displayBeanFactoryGetBean",()->beanFactory.getBean(User.class));
	}

	private static void printBeansException(String source,Runnable runnable) {
		System.err.println("source  from: "+source);
		try {
			runnable.run();
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}

}
