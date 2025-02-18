package com.example.newtest.controller;


import com.example.newtest.common.MyResult;
import com.example.newtest.enity.BusinessTable;
import com.example.newtest.service.BusinessTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    private BusinessTableService businessTableService;
    @GetMapping("/list")
//    @PreAuthorize("hasAuthority('business:list')")
    public MyResult loginOut( BusinessTable businessTable) {
        List<BusinessTable> businessTables = businessTableService.listPage(businessTable);
        return MyResult.ok(businessTables);
    }
}
