package com.cliche.newtest.controller;


import com.cliche.newtest.common.MyResult;
import com.cliche.newtest.enity.BusinessTable;
import com.cliche.newtest.service.BusinessTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    private BusinessTableService businessTableService;
    @GetMapping("/list")
//    @PreAuthorize("hasAuthority('business:list')")
    public MyResult listPage( BusinessTable businessTable) {
        List<BusinessTable> businessTables = businessTableService.listPage(businessTable);
        return MyResult.ok(businessTables);
    }

    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('business:list')")
    public MyResult add(@RequestBody BusinessTable businessTable) {
        businessTableService.save(businessTable);
        return MyResult.success("新增成功");
    }

    @PostMapping("/update")
//    @PreAuthorize("hasAuthority('business:list')")
    public MyResult update(@RequestBody BusinessTable businessTable) {
        Assert.isTrue(businessTable.getId() != null, "id不能为空");
        businessTableService.updateById(businessTable);
        return MyResult.success("新增成功");
    }

    @DeleteMapping("/delete")
//    @PreAuthorize("hasAuthority('business:list')")
    public MyResult delete(@RequestParam Long id) {
        businessTableService.removeById(id);
        return MyResult.success("新增成功");
    }
}
