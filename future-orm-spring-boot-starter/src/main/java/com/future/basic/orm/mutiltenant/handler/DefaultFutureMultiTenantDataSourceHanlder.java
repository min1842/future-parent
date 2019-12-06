package com.future.basic.orm.mutiltenant.handler;

import java.io.Serializable;
import java.util.Optional;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.springframework.util.Assert;

import com.future.basic.orm.mutiltenant.FutureThreadLocal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultFutureMultiTenantDataSourceHanlder implements FutureMultiTenantDataSourceHandler {

	@Override
	public DataSource getMultiTenantDataSource(Environment environment) {
		DataSource dataSource = Optional.ofNullable(lookupTenantdaDataSource()).orElse(environment.getDataSource());
		Assert.notNull(dataSource, "dataSource must not be null");
		return dataSource;
	}

	protected DataSource lookupTenantdaDataSource() {
		Serializable mark = FutureThreadLocal.getThreadLocalMark();
		if (log.isInfoEnabled()) {
			log.info("Switch Multi Tenant : {1}", mark);
		}
		DataSource dataSource = MULTI_TENANT_DATASOURCE_MAP.get(mark);
		if (dataSource == null) {

		}
		return dataSource;
	}

}
