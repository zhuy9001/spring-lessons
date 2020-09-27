package com.zhuyc.spring.ioc.dependency.injection;

import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * @author zhuyc
 * @Description 基于 XML 资源的依赖  方法注入示例
 * @Classname XmlDependencySetterInjectionDemo
 * @PackageName com.zhuyc.spring.ioc.dependency.injection
 * @Date 2020/9/24 16:12
 */
public class AnnotationDependencyMethodInjectionDemo {
	private    UserHolder userHolder;

	private UserHolder userHolder2;

	@Autowired
	public void initUserHolder(UserHolder userHolder){
		this.userHolder=userHolder;
	}

	@Resource
	public void initUserHolder2(UserHolder userHolder){
		this.userHolder2=userHolder;
	}

	@Bean
	public UserHolder userHolder(User user)
	{
		return new UserHolder(user);
	}

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(AnnotationDependencyMethodInjectionDemo.class);
		XmlBeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(applicationContext);
		String sourcePath="classpath:/META-INF/dependency-lookup-context.xml";
		//加载 XML 资源， 解析并且生成 beandefinition
		beanDefinitionReader.loadBeanDefinitions(sourcePath);
		applicationContext.refresh();
		AnnotationDependencyMethodInjectionDemo dependencyFieldInjectionDemo=
				applicationContext.getBean(AnnotationDependencyMethodInjectionDemo.class);
		UserHolder userHolder=dependencyFieldInjectionDemo.userHolder;
//		UserHolder userHolder=applicationContext.getBean(UserHolder.class);
		System.out.println(userHolder);
		System.out.println(dependencyFieldInjectionDemo.userHolder2);
		System.out.println(dependencyFieldInjectionDemo.userHolder2==userHolder);

		applicationContext.close();
	}




}
