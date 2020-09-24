package com.zhuyc.spring.bean.definition;

import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhuyc
 * @Description Bean 实例化示例
 * @Classname BeanInstantinationDemo
 * @PackageName com.zhuyc.spring.bean.definition
 * @Date 2020/9/23 9:55
 */
public class BeanInstantiationDemo {

	public static void main(String[] args) {
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation" +
				"-context.xml");
		User user= beanFactory.getBean("user-by-static-method",User.class);
		User userByInstanceMethod= beanFactory.getBean("user-by-instance-method",User.class);

		User userByFactoryBean= beanFactory.getBean("user-by-instance-method",User.class);
		System.out.println(user);
		System.out.println(userByInstanceMethod);
		System.out.println(userByFactoryBean);
		System.out.println(user==userByInstanceMethod);

		System.out.println(user==userByFactoryBean);
	}
}
