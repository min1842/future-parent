package com.future.basic.orm;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

import com.future.basic.orm.properties.PageHelperProperties;
import com.github.pagehelper.PageInterceptor;

@Configuration
@ConditionalOnClass(value = SqlSessionFactoryBean.class)
public class PageHelperConfiguration {

	@Autowired
	private List<SqlSessionFactory> sqlSessionfactoryBeans;

	@Autowired
	private PageHelperProperties properties;

	@PostConstruct
	public void addPageHelperInterceptor() {
		PageInterceptor interceptor = new PageInterceptor();
		interceptor.setProperties(properties.getProperties());
		sqlSessionfactoryBeans.forEach(sessionFactory -> sessionFactory.getConfiguration().addInterceptor(interceptor));
	}
}
