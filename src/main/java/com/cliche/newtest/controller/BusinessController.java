package com.cliche.newtest.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cliche.newtest.common.MyResult;
import com.cliche.newtest.enity.BusinessTable;
import com.cliche.newtest.service.BusinessTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    private BusinessTableService businessTableService;

    @GetMapping("/list")
//    @PreAuthorize("hasAuthority('business:list')")
    public MyResult list(BusinessTable businessTable) {
        List<BusinessTable> businessTables = businessTableService.listNoPage(businessTable);
        return MyResult.ok(businessTables);
    }

    @GetMapping("/listPage")
//    @PreAuthorize("hasAuthority('business:list')")
    public MyResult listPage(
            BusinessTable businessTable,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo

    ) {
        Page<BusinessTable> page = new Page<>(pageNo, pageSize);
        IPage<BusinessTable> businessTables = businessTableService.listPage(page,businessTable);
        return MyResult.ok(businessTables);
    }

    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('business:list')")
    public MyResult add(@RequestBody BusinessTable businessTable) {
        businessTable.setJoinDateStart(businessTable.getJoinDateStart()!= null?businessTable.getJoinDateStart():new Date());
        businessTable.setJoinDateEnd(businessTable.getJoinDateEnd()!= null?businessTable.getJoinDateEnd():new Date());
        businessTableService.save(businessTable);
        return MyResult.success("新增成功");
    }

    @PostMapping("/update")
//    @PreAuthorize("hasAuthority('business:list')")
    public MyResult update(@RequestBody BusinessTable businessTable) {
        Assert.isTrue(businessTable.getId() != null, "id不能为空");
        businessTableService.updateById(businessTable);
        return MyResult.success("修改成功");
    }

    @DeleteMapping("/delete")
//    @PreAuthorize("hasAuthority('business:list')")
    public MyResult delete(@RequestParam Long id) {
        businessTableService.removeById(id);
        return MyResult.success("删除成功");
    }
}
