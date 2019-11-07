package com.future.basic.framework.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TsUserInfoModel extends FutureCommonModel {

	private static final long serialVersionUID = -6401318512704437879L;

	private String id;
	private String userAccount;
	private String userPassword;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String userDescription;
	private String userStatus;
}
