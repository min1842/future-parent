package com.future.basic.orm.mutiltenant;

import java.io.Serializable;

import org.springframework.util.StringUtils;

public final class FutureThreadLocal {

	private FutureThreadLocal() {
	}

	private static final ThreadLocal<Serializable> MULTI_TENANT_LOCAL = new ThreadLocal<>();

	public static void setMutiTenantLocalMark(String localMark) {
		MULTI_TENANT_LOCAL.set(localMark);
	}

	public static Serializable getThreadLocalMark() {
		Serializable mark = MULTI_TENANT_LOCAL.get();
		if (!StringUtils.isEmpty(mark)) {
			return mark;
		}
		throw new IllegalArgumentException("线程内没有租户标识");
	}

	public static void remove() {
		MULTI_TENANT_LOCAL.remove();
	}
}
