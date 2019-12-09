package com.future.basic.orm.mutiltenant.handler;

import java.util.Optional;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.springframework.util.Assert;

import com.future.basic.orm.mutiltenant.FutureThreadLocal;
import com.future.basic.orm.mutiltenant.cache.FutureMapCache;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultFutureMultiTenantDataSourceHanlder implements FutureMultiTenantDataSourceHandler {

	@Override
	public DataSource getMultiTenantDataSource(Environment environment) {
		String mark = FutureThreadLocal.getThreadLocalMark();
		DataSource dataSource = Optional.ofNullable(lookupTenantdaDataSource(mark)).orElse(environment.getDataSource());
		Assert.notNull(dataSource, "dataSource must not be null");
		if (log.isInfoEnabled()) {
			log.info("Switch Multi Tenant : [{1}],[{2}]", mark, dataSource.getClass());
		}
		return dataSource;
	}

	/**
	 * Look Up DataSource
	 * 
	 * @param mark
	 * @return
	 */
	protected DataSource lookupTenantdaDataSource(String mark) {
		DataSource dataSource = FutureMapCache.MULTI_TENANT_DATASOURCE_MAP.get(mark);
		if (dataSource == null) {
			Optional<DataSource> dataSourceOpt = Optional.ofNullable(createDataSource());
			if (dataSourceOpt.isPresent()) {
				dataSource = dataSourceOpt.get();
				FutureMapCache.MULTI_TENANT_DATASOURCE_MAP.put(mark, dataSource);
			}
		}
		return dataSource;
	}

}
