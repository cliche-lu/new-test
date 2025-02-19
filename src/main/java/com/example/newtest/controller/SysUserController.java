package com.example.newtest.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.newtest.common.MyResult;
import com.example.newtest.enity.LoginUser;
import com.example.newtest.enity.SysUser;
import com.example.newtest.service.SysUserService;
import com.example.newtest.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private RedisUtil redisUtil;
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
    @GetMapping("/getNowLoginUser1")
//    @PreAuthorize("hasAuthority('sys:user:getNowLoginUser')")
    public MyResult getNowLoginUser1() {
        LoginUser one = sysUserService.getNowLoginUser1();
        return MyResult.ok(one);
    }
    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('sys:user:getUserByUserNamer')")
    public MyResult add(@RequestBody SysUser sysUser) {
        sysUser.setUserId(String.valueOf(UUID.randomUUID()));
        sysUserService.save(sysUser);
        return MyResult.success("新增成功！");
    }

    @DeleteMapping("/delete")
//    @PreAuthorize("hasAuthority('sys:user:getUserByUserNamer')")
    public MyResult add(@RequestParam Long id) {
        SysUser byId = sysUserService.getById(id);
        redisUtil.del(byId.getUserId());
        sysUserService.removeById(id);
        return MyResult.success("删除成功！");
    }

    @PostMapping("/update")
//    @PreAuthorize("hasAuthority('sys:user:update')")
    public MyResult update(@RequestBody SysUser sysUser) {
        Assert.isTrue(sysUser.getId() != null, "id不能为空");
        SysUser byId = sysUserService.getById(sysUser);
        redisUtil.del(byId.getUserId());
        sysUserService.updateById(sysUser);
        return MyResult.success("修改成功！");
    }
}
