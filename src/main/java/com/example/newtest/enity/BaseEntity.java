package com.example.newtest.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 创建人
     */
    @TableField(value = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 修改人
     */
    @TableField(value = "update_by")
    private String updateBy;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 0表示未删除,1表示删除
     */
    @TableField(value = "del_flag",select = false)
    private Integer delFlag;

    /**
     * 版本号
     */
    @TableField(value = "reversion")
    @Version
    private Integer reversion;

    /**
     * 多租户
     */
    @TableField(value = "tenant_id")
    private String tenantId;
}
