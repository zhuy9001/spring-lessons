package com.zhuyc.spring.bean.definition;

import com.zhuyc.spring.bean.factory.DefaultUserFactory;
import com.zhuyc.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname BeanInitializationDemo
 * @PackageName com.zhuyc.spring.bean.definition
 * @Date 2020/9/23 11:34
 */
public class BeanInitializationDemo {
	public static void main(String[] args) {
		//创建 BeanFactory 容器
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		//注册 configuration class 配置类
		applicationContext.register(BeanInitializationDemo.class);
		//启动应用上下文
		applicationContext.refresh();
		//非延迟初始化在Spring应用上下文启动完成后初始化
		System.out.println("spring 应用上下文已启动...");
		//依赖查找 UserFactory
		UserFactory userFactory=applicationContext.getBean(UserFactory.class);

		System.out.println(userFactory);
		System.out.println("spring 应用上下文准备关闭...");
		applicationContext.close();
		System.out.println("spring 应用上下文已关闭...");
	}

	@Bean(initMethod="initUserFactory",destroyMethod="doDestroy")
	@Lazy(value=false)
	public DefaultUserFactory userFactory(){
		return new DefaultUserFactory();
	}

}
