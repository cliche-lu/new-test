package com.example.newtest.enity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

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

    /**
     * 用户id
     */
    private String userId;

    @TableField(exist = false)
    private Long deptId;



    @TableField(exist = false)
    private Set<String> roles;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}
