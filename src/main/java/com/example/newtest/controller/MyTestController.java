package com.example.newtest.controller;


import com.example.newtest.common.Result;
import com.example.newtest.enity.User;
import com.example.newtest.service.MyTestService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myTest")
public class MyTestController {
    @Resource
    private MyTestService myTestService;
    @Resource
    private User user;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public Result list() {
        System.out.println("user = " + user);
        return Result.ok(myTestService.list());
    }
}
