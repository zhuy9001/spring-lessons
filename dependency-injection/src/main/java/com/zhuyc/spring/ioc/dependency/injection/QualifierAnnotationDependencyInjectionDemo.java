package com.zhuyc.spring.ioc.dependency.injection;

import com.zhuyc.spring.ioc.dependency.injection.annotation.UserGroup;
import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname QualifierAnnotationDependencyInjectionDemo
 * @PackageName com.zhuyc.spring.ioc.dependency.injection
 * @Date 2020/9/27 14:39
 */
public class QualifierAnnotationDependencyInjectionDemo {

	@Autowired
	private User user;

	@Autowired
	@Qualifier("user")
	private User namedUser;

	@Bean
	@Qualifier
	public User user1(){
		return createUser(7L);
	}

	@Bean
	@Qualifier
	public User user2(){

		return createUser(8L);
	}

	@Bean
	@UserGroup
	public User user3(){
		return createUser(9L);
	}

	@Bean
	@UserGroup
	public User user4(){
		return createUser(10L);
	}

	@Autowired
	private Collection<User> allUsers;

	@Autowired
	@Qualifier
	private Collection<User> qualifierUsers;

	@Autowired
	@UserGroup
	private Collection<User> groupUsers;

	private static User createUser(Long id){
		User user=new User();
		user.setId(id);
		return user;

	}

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(QualifierAnnotationDependencyInjectionDemo.class);
		XmlBeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(applicationContext);
		String sourcePath="classpath:/META-INF/dependency-lookup-context.xml";
		//加载 XML 资源， 解析并且s生成 beandefinition
		beanDefinitionReader.loadBeanDefinitions(sourcePath);
		applicationContext.refresh();
		QualifierAnnotationDependencyInjectionDemo demo=
				applicationContext.getBean(QualifierAnnotationDependencyInjectionDemo.class);
		System.out.println("demo.user："+demo.user);
		System.out.println("demo.namedUser："+demo.namedUser);
		System.out.println("demo.allUsers："+demo.allUsers);
		System.out.println("demo.qualifier："+demo.qualifierUsers);
		System.out.println("demo.groupUsers："+demo.groupUsers);
		applicationContext.close();
	}


}
