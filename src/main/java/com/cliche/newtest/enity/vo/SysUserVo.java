package com.cliche.newtest.enity.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class SysUserVo implements Serializable {

    private Long id;
    /**
     * 用户名
     */
    private String username;
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
}
