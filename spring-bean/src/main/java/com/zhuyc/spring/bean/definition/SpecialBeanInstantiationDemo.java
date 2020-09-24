package com.zhuyc.spring.bean.definition;

import com.zhuyc.spring.bean.factory.DefaultUserFactory;
import com.zhuyc.spring.bean.factory.UserFactory;
import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author zhuyc
 * @Description Bean 实例化示例
 * @Classname BeanInstantinationDemo
 * @PackageName com.zhuyc.spring.bean.definition
 * @Date 2020/9/23 9:55
 */
public class SpecialBeanInstantiationDemo {

	public static void main(String[] args) {

		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");
		AutowireCapableBeanFactory beanFactory=applicationContext.getAutowireCapableBeanFactory();


		ServiceLoader<UserFactory> serviceLoader=beanFactory.getBean("userFactoryServiceLoader",ServiceLoader.class);
//		demoServiceLoader();
		displayServiceLoader(serviceLoader);

		UserFactory userFactory=beanFactory.createBean(DefaultUserFactory.class);
		System.out.println(userFactory.createUser());

	}

	private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
		Iterator<UserFactory> iterator=serviceLoader.iterator();
		while (iterator.hasNext()){
			UserFactory factory=iterator.next();
			System.out.println(factory.createUser());
		}
	}

	public  static void demoServiceLoader(){
		ServiceLoader<UserFactory> serviceLoader=ServiceLoader.load(UserFactory.class,
				Thread.currentThread().getContextClassLoader());
		displayServiceLoader(serviceLoader);
	}
}
