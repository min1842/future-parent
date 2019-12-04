package com.future.basic.orm.datasource;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * 自定义SqlSessionFactory 实现多租户
 * 
 * @author hzhang
 *
 */
@Component("futureSqlSessionFactoryBuilder")
public class FutureSqlSessionFactoryBuilder extends SqlSessionFactoryBuilder implements BeanFactoryAware {
	private BeanFactory beanFactory;

	@Override
	public SqlSessionFactory build(Configuration config) {
		return new FutureSqlSessionFactory(config, beanFactory);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

}
