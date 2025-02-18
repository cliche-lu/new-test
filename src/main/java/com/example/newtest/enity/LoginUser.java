package com.example.newtest.enity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 在线用户信息
 * </p>
 *
 * @Author scott
 * @since 2018-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LoginUser implements Serializable {

	private static final long serialVersionUID = 6749126258686446020L;

	/**
	 * 登录人id
	 */
//	@SensitiveField
	private Long id;

	private String userId;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 电话号
	 */
	private String phone;

	/**
	 * 真实姓名
	 */
	private String realName;

	/**
	 * 状态
	 */
	private String status;

	/**
	 * 权限
	 */
	@TableField(exist = false)
	private List<SysPermission> roles;

}
