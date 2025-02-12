package com.example.newtest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.newtest.enity.DemoTestData;
import com.example.newtest.enity.MyTest;
import com.example.newtest.mapper.MyTestMapper;
import com.example.newtest.service.MyTestService;
import org.springframework.stereotype.Service;

/**
* @author 93285
* @description 针对表【my_test】的数据库操作Service实现
* @createDate 2024-07-31 15:22:19
*/
@Service
public class MyTestServiceImpl extends ServiceImpl<MyTestMapper, MyTest>
    implements MyTestService {

    @Override
    public void importByExcel(DemoTestData data) {
        this.baseMapper.importByExcel(data);
    }
}




