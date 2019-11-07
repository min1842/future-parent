package com.future.basic.framework.model;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
public class TsModuleModel extends FutureCommonModel {

	private static final long serialVersionUID = -8985997520573004346L;

	private String id;
	private String moduleCode;
	private String moduleName;
	private String moduleIcon;
	private String moduleDescription;
	private String moduleType;
	private String moduleUrl;
	private String moduleOrder;
	private String moduleStatus;
	private String moduleParentId;
	private String modulePath;
}
