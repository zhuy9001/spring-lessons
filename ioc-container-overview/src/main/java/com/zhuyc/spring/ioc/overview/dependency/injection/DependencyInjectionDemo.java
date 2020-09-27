package com.zhuyc.spring.ioc.overview.dependency.injection;

import com.zhuyc.spring.ioc.overview.domain.User;
import com.zhuyc.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author zhuyc
 * @Description 依赖查找示例
 * @Classname DependencyLookupDemo
 * @PackageName com.zhuyc.spring.ioc.overview.dependency.lookup
 * @Date 2020/9/21 15:41
 */
public class DependencyInjectionDemo {

	public static void main(String[] args) {
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context" +
				".xml");
		//自定义Bean
		UserRepository repository=(UserRepository) beanFactory.getBean("userRepository");
//		System.out.println(repository.getUsers());

		//依赖注入(内建依赖)
		System.out.println(repository.getBeanFactory());
//		System.out.println(repository.getBeanFactory()==beanFactory);
		ObjectFactory<User> objectFactory=repository.getUserObjectFactory();
		System.out.println(objectFactory.getObject());

		ObjectFactory<ApplicationContext> contextObjectFactory=repository.getObjectFactory();
		System.out.println(beanFactory==contextObjectFactory.getObject());
		//依赖查找（）
//		System.out.println(beanFactory.getBean(BeanFactory.class));

		//容器内建 Bean
		Environment environment=beanFactory.getBean(Environment.class);
		System.out.println("获取 Environment 类型 的Bean:"+environment);
	}


}
