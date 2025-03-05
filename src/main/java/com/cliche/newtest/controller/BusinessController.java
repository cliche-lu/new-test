package com.cliche.newtest.controller;


import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cliche.newtest.common.DataTypeEnum;
import com.cliche.newtest.common.MyResult;
import com.cliche.newtest.enity.BusinessTable;
import com.cliche.newtest.enity.LoginUser;
import com.cliche.newtest.enity.SysUser;
import com.cliche.newtest.mapper.SysUserMapper;
import com.cliche.newtest.service.BusinessTableService;
import com.cliche.newtest.utils.SecurityUtils;
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

    @Autowired
    private SysUserMapper sysUserMapper;

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
        IPage<BusinessTable> businessTables = businessTableService.listPage(page, businessTable);
        return MyResult.ok(businessTables);
    }

    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('business:list')")
    public MyResult add(@RequestBody BusinessTable businessTable) {
        businessTable.setJoinDateStart(businessTable.getJoinDateStart() != null ? businessTable.getJoinDateStart() : new Date());
        businessTable.setJoinDateEnd(businessTable.getJoinDateEnd() != null ? businessTable.getJoinDateEnd() : new Date());
        if (StringUtils.hasLength(businessTable.getDataType())) {
            if (DataTypeEnum.ONE.getCode().equals(businessTable.getDataType())) {
                if (StringUtils.hasLength(businessTable.getUsers())) {
                    SysUser sysUser = sysUserMapper.selectOne(
                            new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, businessTable.getUsers())
                    );
                    if (sysUser != null) {
                        if (sysUser.getLevelScore() != null && sysUser.getLevelScore() > 0) {
                            sysUser.setLevelScore(sysUser.getLevelScore() - 1);
                            businessTable.setOthers("数据类型为1");
                            businessTable.setOthers(
                                    "时间：" + DateUtil.format(new Date(), DatePattern.NORM_DATETIME_FORMAT)
                                            + sysUser.getUsername() + "等级分-1"
                            );
                            sysUserMapper.updateById(sysUser);
                        }
                    }
                }

            }
        } else {
            businessTable.setDataType(DataTypeEnum.TWO.getCode());
        }
        businessTableService.save(businessTable);
        return MyResult.success("新增成功");
    }

    @PostMapping("/update")
//    @PreAuthorize("hasAuthority('business:list')")
    public MyResult update(@RequestBody BusinessTable businessTable) {
        Assert.isTrue(businessTable.getId() != null, "id不能为空");
        BusinessTable byId = businessTableService.getById(businessTable);
        if (izAllowUpdate(byId))
            return MyResult.fail("请先登录");
        businessTableService.updateById(businessTable);
        return MyResult.success("修改成功");
    }

    // 判断是否允许修改数据
    private boolean izAllowUpdate(BusinessTable businessTable) {
        // 获取当前登录用户
        LoginUser sysUser = SecurityUtils.getSysUser();
        // 如果当前用户为空，则允许更新
        if (sysUser == null) {
            return true;
        }
        // 断言当前用户名与businessTable的创建者相同，或者当前用户名为admin
        Assert.isTrue(sysUser.getUsername().equals(businessTable.getCreateBy()) || sysUser.getUsername().equals("admin"), "只能修改自己创建的数据");
        // 否则不允许更新
        return false;
    }

    @DeleteMapping("/delete")
//    @PreAuthorize("hasAuthority('business:list')")
    public MyResult delete(@RequestParam Long id) {
        Assert.isTrue(id != null, "id不能为空");
        BusinessTable byId = businessTableService.getById(id);
        if (izAllowUpdate(byId))
            return MyResult.fail("请先登录");
        businessTableService.removeById(id);
        return MyResult.success("删除成功");
    }
}
