package com.zhuyc.spring.ioc.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhuyc
 * @Description 基于 XML 资源的依赖  constructor方法注入示例
 * @Classname XmlDependencySetterInjectionDemo
 * @PackageName com.zhuyc.spring.ioc.dependency.injection
 * @Date 2020/9/24 16:12
 */
public class ApiDependencyConstructorInjectionDemo {

	public static void main(String[] args) {

		//创建 BeanFactory容器
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		BeanDefinition beanDefinition=createUserHolderBeanDefinition();
		applicationContext.registerBeanDefinition("userHolder",beanDefinition);
		XmlBeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(applicationContext);
		String sourcePath="classpath:/META-INF/dependency-lookup-context.xml";
		//加载 XML 资源， 解析并且s生成 beandefinition
		beanDefinitionReader.loadBeanDefinitions(sourcePath);
		applicationContext.refresh();
		UserHolder userHolder=applicationContext.getBean(UserHolder.class);
		System.out.println(userHolder);

		applicationContext.close();
	}

//	@Bean
//	public UserHolder userHolder(User user) {
//		return new UserHolder(user);
//	}

	private  static BeanDefinition createUserHolderBeanDefinition(){
		BeanDefinitionBuilder definitionBuilder=BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
//		definitionBuilder.addPropertyReference("user", "superUser");
		definitionBuilder.addConstructorArgReference("superUser");
		return definitionBuilder.getBeanDefinition();

	}
}
