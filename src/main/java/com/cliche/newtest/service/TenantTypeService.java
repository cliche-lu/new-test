package com.cliche.newtest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cliche.newtest.enity.TenantType;

import java.util.List;

/**
* @author 93285
* @description 针对表【tenant_type】的数据库操作Service
* @createDate 2025-03-05 14:20:24
*/
public interface TenantTypeService extends IService<TenantType> {
    List<TenantType> getTenantType();
}
