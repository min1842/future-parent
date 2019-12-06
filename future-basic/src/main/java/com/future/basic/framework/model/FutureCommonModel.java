package com.future.basic.framework.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FutureCommonModel implements Serializable {

	private static final long serialVersionUID = -1313766196466615754L;

	private int pageNum;
	private int pageSize = 10;
	private int totalCount;
	private String reateBy;
	private String reateTm;
	private String pdateBy;
	private String pdateTm;
}
