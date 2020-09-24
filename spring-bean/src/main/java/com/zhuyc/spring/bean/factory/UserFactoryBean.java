package com.zhuyc.spring.bean.factory;

import com.zhuyc.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author zhuyc
 * @Description {@link com.zhuyc.spring.ioc.overview.domain.User} Bean
 * 的{@link org.springframework.beans.factory.FactoryBean}实现
 * @Classname UserFactoryBean
 * @PackageName com.zhuyc.spring.bean.factory
 * @Date 2020/9/23 10:42
 */
public class UserFactoryBean implements FactoryBean {
	@Override
	public Object getObject() throws Exception {

		return User.createUser();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
