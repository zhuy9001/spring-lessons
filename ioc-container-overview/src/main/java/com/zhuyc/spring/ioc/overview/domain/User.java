package com.zhuyc.spring.ioc.overview.domain;

import com.zhuyc.spring.ioc.overview.enums.City;
import org.springframework.core.io.Resource;

import java.util.Arrays;
import java.util.List;

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
	public City city;
	private City[] workCity;
	private List<City> lifeCitys;
	private Resource configFileLocal;


	public List<City> getLifeCitys() {
		return lifeCitys;
	}

	public void setLifeCitys(List<City> lifeCitys) {
		this.lifeCitys=lifeCitys;
	}

	public City[] getWorkCity() {
		return workCity;
	}

	public void setWorkCity(City[] workCity) {
		this.workCity=workCity;
	}

	public Resource getConfigFileLocal() {
		return configFileLocal;
	}

	public void setConfigFileLocal(Resource configFileLocal) {
		this.configFileLocal=configFileLocal;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city=city;
	}

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
				", city=" + city +
				", workCity=" + Arrays.toString(workCity) +
				", lifeCitys=" + lifeCitys +
				", configFileLocal=" + configFileLocal +
				'}';
	}

	public static User createUser() {
		User user=new User();
		user.setId(2L);
		user.setName("老陈");
		return user;
	}
}
