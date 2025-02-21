package com.cliche.newtest.controller;

import com.cliche.newtest.common.MyResult;
import com.cliche.newtest.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginController {
    @Autowired
    private SysUserService sysUserService;
    @PostMapping("/login")
    public MyResult login(@RequestParam String username, @RequestParam String password) {
        String token = sysUserService.login(username, password);
        return MyResult.success(token);
    }

}
