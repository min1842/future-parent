package com.future.basic.framework.mapper;

import java.util.List;

import com.future.basic.framework.model.TsUserInfoModel;

public interface TsUserMapper {

	List<TsUserInfoModel> queryUserInfoByAccountOrEmail();
}
