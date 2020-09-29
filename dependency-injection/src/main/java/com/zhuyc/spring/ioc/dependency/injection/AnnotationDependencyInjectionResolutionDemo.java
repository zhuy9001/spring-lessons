package com.zhuyc.spring.ioc.dependency.injection;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.zhuyc.spring.ioc.dependency.injection.annotation.InjectedUser;
import com.zhuyc.spring.ioc.dependency.injection.annotation.MyAutowired;
import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.Optional;

import static org.springframework.context.annotation.AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME;

/**
 * @author zhuyc
 * @Description 注解驱动依赖注入的处理过程
 * @Classname QualifierAnnotationDependencyInjectionDemo
 * @PackageName com.zhuyc.spring.ioc.dependency.injection
 * @Date 2020/9/27 14:39
 */
public class AnnotationDependencyInjectionResolutionDemo {

	@Autowired
	private User user;

	@MyAutowired
	private Optional<User> userOptional;

	@InjectedUser
	private User myInjectUser;



	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(AnnotationDependencyInjectionResolutionDemo.class);
		XmlBeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(applicationContext);
		String sourcePath="classpath:/META-INF/dependency-lookup-context.xml";
		//加载 XML 资源， 解析并且s生成 beandefinition
		beanDefinitionReader.loadBeanDefinitions(sourcePath);
		applicationContext.refresh();
		AnnotationDependencyInjectionResolutionDemo demo=
				applicationContext.getBean(AnnotationDependencyInjectionResolutionDemo.class);
		System.out.println("demo.user："+demo.user);
		System.out.println("demo.userOptional："+demo.userOptional);
		System.out.println("demo.myInjectUser："+demo.myInjectUser);


		applicationContext.close();
	}


	@Bean(name="InjectUserAnnotationBeanPostProcessor")
	@Order(Ordered.LOWEST_PRECEDENCE-3)
	public static    InjectUserAnnotationBeanPostProcessor beanPostProcessor(){

		return new InjectUserAnnotationBeanPostProcessor();
	}

}
