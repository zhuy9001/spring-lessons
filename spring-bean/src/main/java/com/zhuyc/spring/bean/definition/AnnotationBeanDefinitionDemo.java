package com.zhuyc.spring.bean.definition;

import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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

		// 通过 BeanDefinition 注册API 实现
		// 1. 命名 Bean的 注册方式
		registerUserBeanDefinition(applicationContext,"zhu-user");
		//2. 非命名 Bean的 注册方式
		registerUserBeanDefinition(applicationContext);

		applicationContext.refresh();
//		Map<String,Conifg> configBeans=applicationContext.getBeansOfType(Conifg.class);

		System.out.println("Config 类型的所有Beans" + applicationContext.getBeansOfType(Conifg.class));

		System.out.println("User 类型的所有Beans" + applicationContext.getBeansOfType(User.class));

		//通过 @Bean方式定义
		//通过 @Componnet方式



		applicationContext.close();
	}

	/**
	 *  命名 Bean的 注册方式
	 * @param registry
	 * @param beanName
	 */
	public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName){
		BeanDefinitionBuilder beanDefinitionBuilder=BeanDefinitionBuilder.genericBeanDefinition(User.class);
		beanDefinitionBuilder.addPropertyValue("id", 1L).addPropertyValue("name", "小哥");

		//判断 beanName 是否为空，如果为空
		if(StringUtils.hasText(beanName)){
			//注册 BeanDefinition
			registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
		}else{
			//非命名的注册方法
			BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
		}
	}

	public static void registerUserBeanDefinition(BeanDefinitionRegistry registry){
		registerUserBeanDefinition(registry,null);
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
