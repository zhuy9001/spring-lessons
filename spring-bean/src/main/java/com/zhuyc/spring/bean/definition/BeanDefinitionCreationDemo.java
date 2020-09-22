package com.zhuyc.spring.bean.definition;

import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author zhuyc
 * @Description {@link org.springframework.beans.factory.config.BeanDefinition} 构建
 * @Classname BeanDefinitionCreationDemo
 * @PackageName com.zhuyc.spring.bean.definition
 * @Date 2020/9/22 14:46
 */
public class BeanDefinitionCreationDemo {

	public static void main(String[] args) {
		//通过 BeanDefinitionBuilder 构建
		BeanDefinitionBuilder beanDefinitionBuilder=BeanDefinitionBuilder.genericBeanDefinition(User.class);
		//通过属性设置
		beanDefinitionBuilder.addPropertyValue("name", "小朱").addPropertyValue("id", 10);
		//获取 BeanDefinition实例
		BeanDefinition beanDefinition=beanDefinitionBuilder.getBeanDefinition();
		//BeanDefinition 并非bean的最终形态

		//通过 AbstractBeanDefinition 以及派生类
		GenericBeanDefinition genericBeanDefinition=new GenericBeanDefinition();
		//设置Bean的类型
		genericBeanDefinition.setBeanClass(User.class);

		MutablePropertyValues propertyValues=new MutablePropertyValues();
		propertyValues.addPropertyValue("id",12);
		propertyValues.addPropertyValue("name","老先生");
		genericBeanDefinition.setPropertyValues(propertyValues);

	}
}
