package com.example.newtest.service;

import com.example.newtest.enity.LoginUser;
import com.example.newtest.enity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author 93285
 * @description 针对表【sys_user】的数据库操作Service
 * @createDate 2025-02-14 10:45:49
 */
public interface SysUserService extends IService<SysUser> {
    SysUser getUserByUsername(String username, String tenantId);
    SysUser getUserByUsername(String username);

    String login(String username, String password);

    LoginUser getNowLoginUser();
    LoginUser getNowLoginUser1();

    void loginOut(String username);
}
