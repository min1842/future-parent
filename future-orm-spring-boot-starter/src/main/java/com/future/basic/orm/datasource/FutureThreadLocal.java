package com.future.basic.orm.datasource;

import java.io.Serializable;

public final class FutureThreadLocal {

	private FutureThreadLocal() {
	}

	public static ThreadLocal<Serializable> multi_tenant = new ThreadLocal<>();
}
