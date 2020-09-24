package com.zhuyc.spring.ioc.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname AutoWiringByNameDependencySetterInjectionDemo
 * @PackageName com.zhuyc.spring.ioc.dependency.injection
 * @Date 2020/9/24 16:56
 */
public class AutoWiringByNameDependencySetterInjectionDemo {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(beanFactory);
		String sourcePath="classpath:/META-INF/autowiring-dependency-setter-context.xml";
		//加载 XML 资源， 解析并且s生成 beandefinition
		beanDefinitionReader.loadBeanDefinitions(sourcePath);
		UserHolder userHolder=beanFactory.getBean(UserHolder.class);
		System.out.println("UserHolde:"+userHolder);
	}
}
