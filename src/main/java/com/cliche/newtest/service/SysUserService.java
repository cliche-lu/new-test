package com.cliche.newtest.service;

import com.cliche.newtest.enity.LoginUser;
import com.cliche.newtest.enity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cliche.newtest.enity.vo.SysUserVo;

import java.util.List;

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

    List<SysUserVo> getUserList();
}
