package com.zhuyc.spring.dependency.lookup;

import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname ObjectProviderDemo
 * @PackageName com.zhuyc.spring.dependency.lookup
 * @Date 2020/9/23 15:53
 */
public class ObjectProviderDemo {

	public static void main(String[] args) {
		//创建 BeanFactory容器
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		//注册	configuration配置类
		applicationContext.register(ObjectProviderDemo.class);
		//启动应用上下文
		applicationContext.refresh();

		lookupByObjectProvider(applicationContext);
		lookupIfAvailable(applicationContext);
		lookupByStreamOps(applicationContext);
		//关闭应用上下文
		applicationContext.close();
	}

	private static void lookupByStreamOps(AnnotationConfigApplicationContext applicationContext){
		ObjectProvider<String> objectProvider=applicationContext.getBeanProvider(String.class);
		/*Iterable<String> stringIterable=objectProvider;
		for(String string:stringIterable){
			System.out.println(string);
		}*/
		objectProvider.stream().forEach(System.out::println);


	}


	private static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext){
		ObjectProvider<User> userObjectProvider=applicationContext.getBeanProvider(User.class);
		User user=userObjectProvider.getIfAvailable(User::createUser);
		System.out.println("当前 User 对象："+ user);

	}

	@Bean
	@Primary
	public String helloWorld(){
		return "helloWorld";
	}

	@Bean
	public String message(){
		return "message";
	}

	private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext){
		ObjectProvider<String> objectProvider=applicationContext.getBeanProvider(String.class);
		System.out.println(objectProvider.getObject());

	}
}
