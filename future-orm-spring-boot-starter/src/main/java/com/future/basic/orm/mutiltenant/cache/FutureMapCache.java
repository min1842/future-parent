package com.future.basic.orm.mutiltenant.cache;

import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FutureMapCache {

	public static final ConcurrentHashMap<String, DataSource> MULTI_TENANT_DATASOURCE_MAP = new ConcurrentHashMap<>();

	public static void putTarget(String key, DataSource target) {
		MULTI_TENANT_DATASOURCE_MAP.put(key, target);
	}

}
