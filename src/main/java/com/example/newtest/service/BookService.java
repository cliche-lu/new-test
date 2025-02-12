package com.example.newtest.service;

import com.alibaba.excel.context.AnalysisContext;
import com.example.newtest.enity.Book;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.newtest.enity.DemoData;

import java.util.List;

/**
* @author Hades
* @description 针对表【book】的数据库操作Service
* @createDate 2023-09-25 17:18:30
*/
public interface BookService extends IService<Book> {

    List<Book> findAll();

    Book findById(Integer id);

    List<Book> findByName(String name);

    List<Book> selectName(String name, String name1);

//    List<Book> findAllTest();


     void invoke(DemoData demoData, AnalysisContext analysisContext) ;

    List<Book> likeTest(String name);
}
