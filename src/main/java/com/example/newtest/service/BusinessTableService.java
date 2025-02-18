package com.example.newtest.service;

import com.example.newtest.enity.BusinessTable;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 93285
* @description 针对表【business_table】的数据库操作Service
* @createDate 2025-02-14 10:44:10
*/
public interface BusinessTableService extends IService<BusinessTable> {

    List<BusinessTable> listPage(BusinessTable businessTable);
}
