package com.zhuyc.spring.ioc.dependency.injection;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author zhuyc
 * @Description 基于 XML 资源的依赖  Setter方法注入示例
 * @Classname XmlDependencySetterInjectionDemo
 * @PackageName com.zhuyc.spring.ioc.dependency.injection
 * @Date 2020/9/24 16:12
 */
public class AnnotationDependencySetterInjectionDemo {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(AnnotationDependencySetterInjectionDemo.class);
		XmlBeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(applicationContext);
		String sourcePath="classpath:/META-INF/dependency-lookup-context.xml";
		//加载 XML 资源， 解析并且s生成 beandefinition
		beanDefinitionReader.loadBeanDefinitions(sourcePath);
		applicationContext.refresh();
		UserHolder userHolder=applicationContext.getBean(UserHolder.class);
		System.out.println(userHolder);

		applicationContext.close();
	}

	@Bean
	public UserHolder userHolder(User user) {
		return new UserHolder(user);
	}
}
