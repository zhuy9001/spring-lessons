package com.zhuyc.spring.ioc.overview.repository;

import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname UserRepository
 * @PackageName com.zhuyc.spring.ioc.overview.repository
 * @Date 2020/9/21 16:46
 */
public class UserRepository {
	private Collection<User> users;

	private BeanFactory  beanFactory;

	private ObjectFactory<User> userObjectFactory;

	private ObjectFactory<ApplicationContext> objectFactory;

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users=users;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory=beanFactory;
	}

	public ObjectFactory<User> getUserObjectFactory() {
		return userObjectFactory;
	}

	public void setUserObjectFactory(ObjectFactory<User> userObjectFactory) {
		this.userObjectFactory=userObjectFactory;
	}

	public ObjectFactory<ApplicationContext> getObjectFactory() {
		return objectFactory;
	}

	public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
		this.objectFactory=objectFactory;
	}
}
