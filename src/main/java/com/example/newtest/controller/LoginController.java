package com.example.newtest.controller;

import com.example.newtest.common.MyResult;
import com.example.newtest.service.SysUserService;
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
