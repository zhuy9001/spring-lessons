package com.zhuyc.spring.ioc.overview.domain;

import com.zhuyc.spring.ioc.overview.annotation.Super;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname SuperUser
 * @PackageName com.zhuyc.spring.ioc.overview.domain
 * @Date 2020/9/21 16:18
 */
@Super
public class SuperUser extends User{
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address=address;
	}

	@Override
	public String toString() {
		return "SuperUser{" +
				"address='" + address + '\'' +
				"} " + super.toString();
	}
}
