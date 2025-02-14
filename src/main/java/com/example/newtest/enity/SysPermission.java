package com.example.newtest.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @TableName sys_permission
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="sys_permission")
@Data
public class SysPermission extends BaseEntity implements Serializable {

    /**
     * 父id
     */
    private Long parentId;

    /**
     * 菜单标题
     */
    private String name;

    /**
     * 路径
     */
    private String url;

    /**
     * 菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)
     */
    private Integer menuType;

    /**
     * 菜单权限编码
     */
    private String perms;

    /**
     * 是否添加数据权限1是0否
     */
    private Integer ruleFlag;

    /**
     * 是否路由菜单: 0:不是  1:是（默认值1）
     */
    private Integer isRoute;

    /**
     * 列权限
     */
    private String columnRole;

    /**
     * 行权限
     */
    private String rowRole;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
