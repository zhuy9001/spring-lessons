package com.zhuyc.spring.ioc.dependency.injection;

import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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



		applicationContext.close();
	}


}
