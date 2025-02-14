package com.example.newtest.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @TableName business_table
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="business_table")
@Data
public class BusinessTable extends BaseEntity implements Serializable {


    /**
     * 描述
     */
    private String remak;

    /**
     * 图片
     */
    private String imag;

    /**
     * 简略地点
     */
    private String address;

    /**
     * 同行人们
     */
    private String users;

    /**
     * 其他
     */
    private String others;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 0表示未删除,1表示删除
     */
    private Integer delFlag;

    /**
     * 版本号
     */
    private Integer reversion;

    /**
     * 多租户
     */
    private String tenantId;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}
