package com.cliche.newtest.enity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;

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
    private String remark;

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
     * 分享至
     */
    private String share;


    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}
