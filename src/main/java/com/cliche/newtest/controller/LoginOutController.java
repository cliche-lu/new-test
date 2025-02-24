package com.cliche.newtest.controller;

import com.cliche.newtest.common.MyResult;
import com.cliche.newtest.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LoginOutController {
    @Autowired
    private SysUserService sysUserService;


}
