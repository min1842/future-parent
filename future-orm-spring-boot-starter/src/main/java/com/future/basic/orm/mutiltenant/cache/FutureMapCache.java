package com.future.basic.orm.mutiltenant.cache;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FutureMapCache {

	public static final ConcurrentHashMap<Serializable, DataSource> MULTI_TENANT_DATASOURCE_MAP = new ConcurrentHashMap<>();

}
