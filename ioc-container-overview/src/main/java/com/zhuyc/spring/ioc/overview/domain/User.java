package com.zhuyc.spring.ioc.overview.domain;

/**
 * @author zhuyc
 * @Description TODO
 * @Classname User
 * @PackageName com.zhuyc.spring.ioc.overview.domain
 * @Date 2020/9/21 15:44
 */
public class User {

	private Long id;
	private String name;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}

	public static User createUser() {
		User user=new User();
		user.setId(2L);
		user.setName("老陈");
		return user;
	}
}
