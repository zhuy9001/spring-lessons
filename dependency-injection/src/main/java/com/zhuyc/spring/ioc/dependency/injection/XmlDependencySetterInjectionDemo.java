package com.zhuyc.spring.ioc.dependency.injection;

import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author zhuyc
 * @Description  基于 XML 资源的依赖  Setter方法注入示例
 * @Classname XmlDependencySetterInjectionDemo
 * @PackageName com.zhuyc.spring.ioc.dependency.injection
 * @Date 2020/9/24 16:12
 */
public class XmlDependencySetterInjectionDemo {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(beanFactory);
		String sourcePath="classpath:/META-INF/dependency-setter-context.xml";
		//加载 XML 资源， 解析并且s生成 beandefinition
		beanDefinitionReader.loadBeanDefinitions(sourcePath);
		UserHolder userHolder=beanFactory.getBean(UserHolder.class);
		System.out.println("UserHolde:"+userHolder);
	}
}
