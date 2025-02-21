package com.cliche.newtest.enity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @TableName sys_role
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="sys_role")
@Data
public class SysRole extends BaseEntity implements Serializable {


    /**
     * 权限类型
     */
    private String roleType;

    /**
     * 运行查询多租户
     */
    private String allowTenant;

    /**
     * 行权限
     */
    private String rowRole;

    /**
     * 列权限
     */
    private String columnRole;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
