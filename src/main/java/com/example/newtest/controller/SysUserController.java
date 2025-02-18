package com.example.newtest.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.newtest.common.MyResult;
import com.example.newtest.enity.LoginUser;
import com.example.newtest.enity.SysUser;
import com.example.newtest.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    //测试
    @GetMapping("/getUserByUserName")
    @PreAuthorize("hasAuthority('sys:user:getUserByUserNamer')")
    public MyResult getUserByUserName(@RequestParam String username) {
        SysUser one = sysUserService.getUserByUsername(username);
        return MyResult.ok(one);
    }

    @GetMapping("/getNowLoginUser")
    @PreAuthorize("hasAuthority('sys:user:getNowLoginUser')")
    public MyResult getNowLoginUser() {
        LoginUser one = sysUserService.getNowLoginUser();
        return MyResult.ok(one);
    }
}
