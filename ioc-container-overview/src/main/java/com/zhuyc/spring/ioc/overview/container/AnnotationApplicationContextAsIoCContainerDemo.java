package com.zhuyc.spring.ioc.overview.container;

import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @author zhuyc
 * @Description 注解能力 {@link ApplicationContext} 作为IoC容器
 * @Classname IoCContainerDemo
 * @PackageName com.zhuyc.spring.ioc.overview.container
 * @Date 2020/9/22 10:48
 */
public class AnnotationApplicationContextAsIoCContainerDemo {

	public static void main(String[] args) {
		//创建 Beanfactory容器
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class);
		applicationContext.refresh();


		lookupCollectionByType(applicationContext);

	}

	private static void lookupCollectionByType(BeanFactory beanFactory) {
		if(beanFactory instanceof ListableBeanFactory){
			ListableBeanFactory listableBeanFactory=(ListableBeanFactory) beanFactory;
			Map<String,User> users=listableBeanFactory.getBeansOfType(User.class);
			System.out.println("查找到的所有的User 集合对象："+users);
		}
	}

	@Bean
	public  User user(){
		User user=new User();
		user.setId(10L);
		user.setName("老朱");
		return user;
	}
}
