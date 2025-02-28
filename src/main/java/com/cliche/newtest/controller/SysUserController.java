package com.cliche.newtest.controller;


import com.cliche.newtest.common.MyResult;
import com.cliche.newtest.enity.LoginUser;
import com.cliche.newtest.enity.SysUser;
import com.cliche.newtest.enity.vo.SysUserVo;
import com.cliche.newtest.service.SysUserService;
import com.cliche.newtest.utils.CustomMd5PasswordEncoder;
import com.cliche.newtest.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private RedisUtil redisUtil;

    @Value("${tenantId}")
    private String reTenantId;
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
    @GetMapping("/getUserList")
//    @PreAuthorize("hasAuthority('sys:user:getNowLoginUser')")
    public MyResult getUserList() {
        List<SysUserVo> list = sysUserService.getUserList();
        return MyResult.ok(list);
    }
    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('sys:user:getUserByUserNamer')")
    public MyResult add(@RequestBody SysUser sysUser) {
        Assert.isTrue(sysUser.getUsername() != null, "用户名不能为空");
        Assert.isTrue(sysUser.getPassword() != null, "密码不能为空");
        SysUser userByUsername = sysUserService.getUserByUsername(sysUser.getUsername());
        Assert.isNull(userByUsername, "用户名已存在！");
        sysUser.setUserId(String.valueOf(UUID.randomUUID()));
        sysUser.setTenantId(reTenantId);
        sysUser.setCreateBy(sysUser.getUsername());
        CustomMd5PasswordEncoder md5 = new CustomMd5PasswordEncoder();
        sysUser.setPassword(md5.encode(sysUser.getPassword()));
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
