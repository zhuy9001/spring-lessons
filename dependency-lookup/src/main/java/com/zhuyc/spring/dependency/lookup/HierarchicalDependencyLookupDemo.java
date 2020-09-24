package com.zhuyc.spring.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname HierarchicalDependencyLookupDemo
 * @PackageName com.zhuyc.spring.dependency.lookup
 * @Date 2020/9/23 16:33
 */
public class HierarchicalDependencyLookupDemo {

	public static void main(String[] args) {
		//创建 BeanFactory容器
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		//注册	configuration配置类
		applicationContext.register(ObjectProviderDemo.class);

		//1.获取 HierarchicalBeanFactory <-ConfigurableBeanFactory<-ConfigurableListableBeanFactory
		ConfigurableListableBeanFactory beanFactory=applicationContext.getBeanFactory();
//		System.out.println("当前 BeanFactory的 Parent BeanFactory ：" + beanFactory.getParentBeanFactory());

		//设置 Parent BeanFactory
		HierarchicalBeanFactory parentBeanFactory=createParentBeanFactory();
		beanFactory.setParentBeanFactory(parentBeanFactory);
//		System.out.println("当前 BeanFactory的 Parent BeanFactory ：" + beanFactory.getParentBeanFactory());

		displayContainsLocalBean(beanFactory, "user");
		displayContainsLocalBean(parentBeanFactory, "user");
		displayContainsBean(beanFactory, "user");
		displayContainsBean(parentBeanFactory, "user");

		//启动应用上下文
		applicationContext.refresh();

		//关闭应用上下文
		applicationContext.close();
	}

	private static void displayContainsBean(HierarchicalBeanFactory beanFactory, String beanName) {
		containsBean(beanFactory, beanName);
		System.out.printf("当前 BeanFactory【%s】是否包含  bean【name：%s 】：%s\n", beanFactory, beanName,
				beanFactory.containsLocalBean(beanName));
	}

	private static boolean containsBean(HierarchicalBeanFactory beanFactory, String beanName) {
		BeanFactory parentBeanFactory=beanFactory.getParentBeanFactory();
		if (parentBeanFactory instanceof HierarchicalBeanFactory) {
			HierarchicalBeanFactory parentHierarchicalBeanFactory=HierarchicalBeanFactory.class.cast(parentBeanFactory);
			if (containsBean(parentHierarchicalBeanFactory, beanName)) {
				return true;
			}
		}
		return beanFactory.containsLocalBean(beanName);
	}

	private static void displayContainsLocalBean(HierarchicalBeanFactory beanFactory, String beanName) {

		System.out.printf("当前 BeanFactory【%s】是否包含 Local bean【name：%s 】：%s\n", beanFactory, beanName,
				beanFactory.containsLocalBean(beanName));
	}

	private static DefaultListableBeanFactory createParentBeanFactory() {
		DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(beanFactory);
		//xml 配置文件 classpath路径
		String location="classpath:/META-INF/dependency-lookup-context.xml";

		reader.loadBeanDefinitions(location);
		return beanFactory;
	}

}
