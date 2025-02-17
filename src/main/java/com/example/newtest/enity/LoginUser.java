package com.example.newtest.enity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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
	private String id;

	/**
	 * 登录人账号
	 */
//	@SensitiveField
	private String username;

	/**
	 * 登录人名字
	 */
//	@SensitiveField
	private String realname;

	/**
	 * 登录人密码
	 */
//	@SensitiveField
	private String password;

     /**
      * 当前登录部门code
      */
    private String orgCode;
	/**
	 * 头像
	 */
//	@SensitiveField
	private String avatar;

	/**
	 * 生日
	 */
//	@SensitiveField
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	/**
	 * 性别（1：男 2：女）
	 */
	private Integer sex;

	/**
	 * 电子邮件
	 */
//	@SensitiveField
	private String email;

	/**
	 * 电话
	 */
//	@SensitiveField
	private String phone;

	/**
	 * 人员来源(1-iwork,2-本系统)
	 */
	private Integer userSource;

	/**
	 * 状态(1：正常 2：冻结 ）
	 */
	private Integer status;

	private Integer delFlag;
	/**
     * 同步工作流引擎1同步0不同步
     */
    private Integer activitiSync;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 *  身份（1 普通员工 2 上级）
	 */
	private Integer userIdentity;

	/**
	 * 管理部门ids
	 */
	private String departIds;

	/**
	 * 管理部门名称
	 */
	//private String departNames;

	/**
	 * 职务，关联职务表
	 */
//	@SensitiveField
	private String post;

	/**
	 * 座机号
	 */
//	@SensitiveField
	private String telephone;

	/**多租户id配置，编辑用户的时候设置*/
	private String relTenantIds;

	/**设备id uniapp推送用*/
	private String clientId;

	private Set<String> permissions;

	/** redis存储用户标志key */
	private String tokenKey;

	/** 用户登录时间 */
	private Long loginTime;

	/** 用户登录过期时间 */
	private Long expireTime;

	/** 上一次修改密码日期 */
	private Date pwdLastUpdateDate;

}
