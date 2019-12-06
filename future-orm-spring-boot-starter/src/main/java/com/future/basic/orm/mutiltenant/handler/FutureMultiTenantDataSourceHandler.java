package com.future.basic.orm.mutiltenant.handler;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.springframework.lang.Nullable;

@FunctionalInterface
public interface FutureMultiTenantDataSourceHandler {

	ConcurrentHashMap<Serializable, DataSource> MULTI_TENANT_DATASOURCE_MAP = new ConcurrentHashMap<>();

	DataSource getMultiTenantDataSource(@Nullable Environment environment);
}
