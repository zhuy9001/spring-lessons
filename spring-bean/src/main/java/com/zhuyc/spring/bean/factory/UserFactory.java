package com.zhuyc.spring.bean.factory;

import com.zhuyc.spring.ioc.overview.domain.User;

/**
 * @author zhuyc
 * @Description {@link User}
 * @Classname UserFactory
 * @PackageName com.zhuyc.spring.bean.factory
 * @Date 2020/9/23 10:08
 */
public interface UserFactory {
	default User createUser(){
		return User.createUser();
	}
}
