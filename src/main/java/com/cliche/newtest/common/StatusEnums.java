package com.cliche.newtest.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态枚举
 *
 * @author harry
 */
@Getter
@AllArgsConstructor
public enum StatusEnums {

	/**
	 * 禁用
	 */
	DISABLE("0", "禁用"),
	/**
	 * 启用
	 */
	ENABLE("1", "启用"),;

	private final String key;

	private final String name;

}
