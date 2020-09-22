package com.zhuyc.spring.bean.definition;

import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname AnnotationBeanDefinitionDemo
 * @PackageName com.zhuyc.spring.bean.definition
 * @Date 2020/9/22 16:38
 */
public class AnnotationBeanDefinitionDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(Conifg.class);
		applicationContext.refresh();
//		Map<String,Conifg> configBeans=applicationContext.getBeansOfType(Conifg.class);

		System.out.println("Config 类型的所有Beans" + applicationContext.getBeansOfType(Conifg.class));

		System.out.println("User 类型的所有Beans" + applicationContext.getBeansOfType(User.class));

		//通过 @Bean方式定义
		//通过 @Componnet方式



		applicationContext.close();
	}


	// 通过  @Component 方式
	@Component
	public static class  Conifg{

		//通过 @bean
		@Bean(name={"user","zhuyc-user"})
		public User user(){
			User user=new User();
			user.setId(10L);
			user.setName("老朱");
			return user;
		}
	}


}
