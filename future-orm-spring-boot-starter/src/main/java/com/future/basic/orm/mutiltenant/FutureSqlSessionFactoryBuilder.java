package com.future.basic.orm.mutiltenant;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.util.Assert;

import com.future.basic.orm.mutiltenant.handler.DefaultFutureMultiTenantDataSourceHanlder;
import com.future.basic.orm.mutiltenant.handler.FutureMultiTenantDataSourceHandler;
import com.future.basic.orm.mutiltenant.handler.FutureSqlSessionFactory;

/**
 * 自定义SqlSessionFactory 实现多租户
 * 
 * @author hzhang
 *
 */
public class FutureSqlSessionFactoryBuilder extends SqlSessionFactoryBuilder {

	private FutureMultiTenantDataSourceHandler handler = new DefaultFutureMultiTenantDataSourceHanlder();

	@Override
	public SqlSessionFactory build(Configuration config) {
		return new FutureSqlSessionFactory(config, handler);
	}

	public <T extends FutureMultiTenantDataSourceHandler> void setMultiTenantDataSourceHandler(T customHandler) {
		Assert.notNull(customHandler, "CustomHandler must not be null");
		this.handler = customHandler;
	}
}
