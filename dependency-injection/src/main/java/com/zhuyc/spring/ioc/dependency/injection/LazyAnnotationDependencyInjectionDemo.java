package com.zhuyc.spring.ioc.dependency.injection;

import com.zhuyc.spring.ioc.dependency.injection.annotation.UserGroup;
import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

/**
 * @author zhuyc
 * @Description ObjectProvider 延迟注入
 * @Classname QualifierAnnotationDependencyInjectionDemo
 * @PackageName com.zhuyc.spring.ioc.dependency.injection
 * @Date 2020/9/27 14:39
 */
public class LazyAnnotationDependencyInjectionDemo {

	@Autowired
	private User user;

	@Autowired
	private ObjectProvider<User> objectProvider;

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(LazyAnnotationDependencyInjectionDemo.class);
		XmlBeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(applicationContext);
		String sourcePath="classpath:/META-INF/dependency-lookup-context.xml";
		//加载 XML 资源， 解析并且s生成 beandefinition
		beanDefinitionReader.loadBeanDefinitions(sourcePath);
		applicationContext.refresh();
		LazyAnnotationDependencyInjectionDemo demo=
				applicationContext.getBean(LazyAnnotationDependencyInjectionDemo.class);
		System.out.println("demo.user："+demo.user);
		System.out.println("demo.objectProvider："+demo.objectProvider.getObject());
		demo.objectProvider.forEach(System.out::println);

		applicationContext.close();
	}


}
