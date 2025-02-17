package com.example.newtest.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @TableName sys_user
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_user")
@Data
public class SysUser extends BaseEntity implements Serializable {


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

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}
