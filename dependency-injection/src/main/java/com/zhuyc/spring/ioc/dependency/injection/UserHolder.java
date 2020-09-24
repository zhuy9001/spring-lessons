package com.zhuyc.spring.ioc.dependency.injection;

import com.zhuyc.spring.ioc.overview.domain.User;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname UserHolder
 * @PackageName com.zhuyc.spring.ioc.dependency.injection
 * @Date 2020/9/24 16:26
 */
public class UserHolder {

	private User user;

	public UserHolder(User user) {
		this.user=user;
	}

	public UserHolder() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user=user;
	}

	@Override
	public String toString() {
		return "UserHolder{" +
				"user=" + user +
				'}';
	}
}
