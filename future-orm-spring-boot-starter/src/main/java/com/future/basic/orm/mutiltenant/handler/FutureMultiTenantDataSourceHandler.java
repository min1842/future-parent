package com.future.basic.orm.mutiltenant.handler;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.springframework.lang.Nullable;

@FunctionalInterface
public interface FutureMultiTenantDataSourceHandler {

	DataSource getMultiTenantDataSource(@Nullable Environment environment);

	default DataSource createDataSource() {
		return null;
	}
}
