package com.zhuyc.spring.ioc.overview.dependency.lookup;

import com.zhuyc.spring.ioc.overview.annotation.Super;
import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author zhuyc
 * @Description 依赖查找示例
 * @Classname DependencyLookupDemo
 * @PackageName com.zhuyc.spring.ioc.overview.dependency.lookup
 * @Date 2020/9/21 15:41
 */
public class DependencyLookupDemo {

	public static void main(String[] args) {
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
//		lookupInrealTime(beanFactory);
//		lookupInlazy(beanFactory);
		lookupByType(beanFactory);
		lookupCollectionByType(beanFactory);
		lookupByAnnotationType(beanFactory);
	}

	private static void lookupByAnnotationType(BeanFactory beanFactory) {

		if(beanFactory instanceof ListableBeanFactory){
			ListableBeanFactory listableBeanFactory=(ListableBeanFactory) beanFactory;
			Map<String, User> users=(Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
			System.out.println("查找标注 @Super 所有的User 集合对象："+users);
		}
	}

	private static void lookupCollectionByType(BeanFactory beanFactory) {
		if(beanFactory instanceof ListableBeanFactory){
			ListableBeanFactory listableBeanFactory=(ListableBeanFactory) beanFactory;
			Map<String,User> users=listableBeanFactory.getBeansOfType(User.class);
			System.out.println("查找到的所有的User 集合对象："+users);
		}
	}

	private static void lookupByType(BeanFactory beanFactory) {
		User user=beanFactory.getBean(User.class);
		System.out.println(user);
	}

	private static void lookupInrealTime(BeanFactory beanFactory){
		User user=(User) beanFactory.getBean("user");
		System.out.println("实时查找："+user);
	}

	private static void lookupInlazy(BeanFactory beanFactory){
		ObjectFactory<User> objectFactory=(ObjectFactory<User>) beanFactory.getBean("objectFactory");
		User user=objectFactory.getObject();
		System.out.println("延时查找："+user);
	}
}
