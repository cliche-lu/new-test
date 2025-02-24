package com.cliche.newtest.controller;

import com.cliche.newtest.common.MyResult;
import com.cliche.newtest.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private SysUserService sysUserService;
    @PostMapping("/login")
    @ResponseBody
    public MyResult login(@RequestParam String username, @RequestParam String password) {
        String token = sysUserService.login(username, password);
        return MyResult.success(token);
    }

    @ResponseBody
    @GetMapping("/loginOut")
    public MyResult loginOut(@RequestParam String username) {
        sysUserService.loginOut(username);
        return MyResult.ok("登出成功！");
    }

    @RequestMapping("/index")
    public String demo() {
        return "index";
    }

}
