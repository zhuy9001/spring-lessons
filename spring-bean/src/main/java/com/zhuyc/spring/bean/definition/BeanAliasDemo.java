package com.zhuyc.spring.bean.definition;

import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname BeanAliasDemo
 * @PackageName com.zhuyc.spring.bean.definition
 * @Date 2020/9/22 16:26
 */
public class BeanAliasDemo {

	public static void main(String[] args) {
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-beandefinitions-context.xml");
		User user=(User) beanFactory.getBean("user",User.class);
		User zhuycUser=(User) beanFactory.getBean("zhuyc-user",User.class);

		System.out.println("zhuycUser是否与 user bean相同"+ (user==zhuycUser));

	}
}
