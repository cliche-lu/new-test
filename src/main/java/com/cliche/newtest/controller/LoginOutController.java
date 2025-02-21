package com.cliche.newtest.controller;

import com.cliche.newtest.common.MyResult;
import com.cliche.newtest.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginOutController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/loginOut")
    public MyResult loginOut(@RequestParam String username) {
        sysUserService.loginOut(username);
        return MyResult.ok("登出成功！");
    }
}
