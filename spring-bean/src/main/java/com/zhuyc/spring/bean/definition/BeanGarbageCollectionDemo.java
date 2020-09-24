package com.zhuyc.spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhuyc
 * @Description Bean 垃圾回收(GC)示例
 * @Classname BeanGarbageCollectionDemo
 * @PackageName com.zhuyc.spring.bean.definition
 * @Date 2020/9/23 14:37
 */
public class BeanGarbageCollectionDemo {

	public static void main(String[] args) throws InterruptedException {
		//创建 BeanFactory 容器
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		//注册 configuration class 配置类
		applicationContext.register(BeanInitializationDemo.class);
		//启动应用上下文
		applicationContext.refresh();


		applicationContext.close();
		System.out.println("spring 应用上下文已关闭...");
		Thread.sleep(5000L);
		System.gc();
		Thread.sleep(5000L);
	}
}
