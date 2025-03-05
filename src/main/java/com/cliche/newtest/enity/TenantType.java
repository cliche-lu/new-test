package com.cliche.newtest.enity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @TableName tenant_type
 */
@TableName(value ="tenant_type")
@Data
public class TenantType implements Serializable {
    /**
     *
     */
    @TableId
    private Long id;

    /**
     * 租户id
     */
    private Integer tenantId;

    /**
     * 租户名
     */
    private String tenantName;

    /**
     * 0表示未删除,1表示删除
     */
    @TableField(value = "del_flag",select = false,fill = FieldFill.INSERT)
    @TableLogic
    private Integer delFlag;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}
