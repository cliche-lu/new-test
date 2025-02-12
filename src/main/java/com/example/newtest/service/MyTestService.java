package com.example.newtest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.newtest.enity.DemoTestData;
import com.example.newtest.enity.MyTest;

import java.util.List;

/**
* @author 93285
* @description 针对表【my_test】的数据库操作Service
* @createDate 2024-07-31 15:22:19
*/
public interface MyTestService extends IService<MyTest> {

    void importByExcel(DemoTestData cachedDataList);
}
