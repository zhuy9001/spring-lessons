package com.zhuyc.spring.bean.definition;

import com.zhuyc.spring.bean.factory.DefaultUserFactory;
import com.zhuyc.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname SingletonBean
 * @PackageName com.zhuyc.spring.bean.definition
 * @Date 2020/9/23 14:44
 */
public class SingletonBeanRegistrationDemo {

	public static void main(String[] args) throws InterruptedException {
		//创建 BeanFactory 容器
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		//注册外部单例对象
		UserFactory userFactory=new DefaultUserFactory();

		ConfigurableListableBeanFactory beanFactory=applicationContext.getBeanFactory();
		beanFactory.registerSingleton("userFactory",userFactory);

		//启动应用上下文
		applicationContext.refresh();

		UserFactory userFactoryByLookup=beanFactory.getBean("userFactory",UserFactory.class);
		System.out.println("userFactory==userFactoryByLookup :"+(userFactory==userFactoryByLookup));

		applicationContext.close();

	}
}

