package com.future.basic.framework.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TsRoleModel extends FutureCommonModel {

	private static final long serialVersionUID = 5575363486145038858L;

	private String id;
	private String roleCode;
	private String roleName;
	private String roleDescription;
	private String roleStatus;
}
