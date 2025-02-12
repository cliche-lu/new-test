package com.example.newtest.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.newtest.enity.DemoTestData;
import com.example.newtest.enity.MyTest;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 93285
* @description 针对表【my_test】的数据库操作Mapper
* @createDate 2024-07-31 15:22:19
* @Entity generator.entity.MyTest
*/
@Mapper
public interface MyTestMapper extends BaseMapper<MyTest> {

    int importByExcel(DemoTestData data);
}




