package com.zhuyc.spring.ioc.overview.container;

import com.zhuyc.spring.ioc.overview.annotation.Super;
import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname IoCContainerDemo
 * @PackageName com.zhuyc.spring.ioc.overview.container
 * @Date 2020/9/22 10:48
 */
public class BeanFactoryAsIoCContainerDemo {

	public static void main(String[] args) {
		//创建 Beanfactory容器
		DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(beanFactory);
		//xml 配置文件 classpath路径
		String location="classpath:/META-INF/dependency-lookup-context.xml";

		int beanDefinitionsCount=reader.loadBeanDefinitions(location);
		System.out.println("Bean 定义加载的数量："+beanDefinitionsCount);
		lookupCollectionByType(beanFactory);

	}

	private static void lookupCollectionByType(BeanFactory beanFactory) {
		if(beanFactory instanceof ListableBeanFactory){
			ListableBeanFactory listableBeanFactory=(ListableBeanFactory) beanFactory;
			Map<String,User> users=listableBeanFactory.getBeansOfType(User.class);
			System.out.println("查找到的所有的User 集合对象："+users);
		}
	}
}
