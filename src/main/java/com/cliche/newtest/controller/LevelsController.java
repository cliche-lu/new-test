package com.cliche.newtest.controller;


import com.cliche.newtest.common.LevelsEnum;
import com.cliche.newtest.common.MyResult;
import com.cliche.newtest.enity.TenantType;
import com.cliche.newtest.service.TenantTypeService;
import com.cliche.newtest.utils.EnumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.standard.expression.EachUtils;

import java.util.List;

@RestController
@RequestMapping("/levels")
public class LevelsController {
    @Autowired
    private TenantTypeService tenantTypeService;

    @GetMapping("/list")
    public MyResult getAllArrivalPeriodsApp() {
        return MyResult.ok(EnumUtil.getByEnumList(LevelsEnum.class));
    }

    @GetMapping("/getTenantType")
    public MyResult getTenantType() {
        List<TenantType> tenantTypes= tenantTypeService.getTenantType();
        return MyResult.ok(tenantTypes);
    }
}
