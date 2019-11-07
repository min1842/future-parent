package com.future.basic.framework.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TsOpertationLogModel extends FutureCommonModel {

	private static final long serialVersionUID = -3221472035894012584L;

	private String id;
	private String requestMethod;
	private String requestUrl;
	private String requestDate;
	private String requestAccount;
	private String requestParameter;
	private String responseStatusCode;
	private String responseJson;
}
