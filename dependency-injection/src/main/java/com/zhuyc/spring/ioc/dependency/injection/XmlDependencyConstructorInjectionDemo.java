package com.zhuyc.spring.ioc.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author zhuyc
 * @Description  基于 XML 资源的依赖  构造器注入
 * @Classname XmlDependencySetterInjectionDemo
 * @PackageName com.zhuyc.spring.ioc.dependency.injection
 * @Date 2020/9/24 16:12
 */
public class XmlDependencyConstructorInjectionDemo {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(beanFactory);
		String sourcePath="classpath:/META-INF/dependency-constructor-context.xml";
		//加载 XML 资源， 解析并且s生成 beandefinition
		beanDefinitionReader.loadBeanDefinitions(sourcePath);
		UserHolder userHolder=beanFactory.getBean(UserHolder.class);
		System.out.println("UserHolde:"+userHolder);
	}
}
