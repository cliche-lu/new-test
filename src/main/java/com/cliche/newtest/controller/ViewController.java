package com.cliche.newtest.controller;

import com.cliche.newtest.common.MyResult;
import com.cliche.newtest.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class ViewController {

    @RequestMapping("/crazyThursday")
    public String login() {
        return "crazyThursday";
    }
}
