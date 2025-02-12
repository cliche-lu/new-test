package com.example.newtest.service.impl;

import com.alibaba.excel.context.AnalysisContext;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.newtest.enity.Book;
import com.example.newtest.enity.DemoData;
import com.example.newtest.mapper.BookMapper;
import com.example.newtest.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author Hades
* @description 针对表【book】的数据库操作Service实现
* @createDate 2023-09-25 17:18:30
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService{
    @Resource
    private BookMapper bookMapper;
//    @Resource
//    BookService bookService;
private List<DemoData> cachedDataList = new ArrayList<>();
    @Override
    /*
        @CacheEvict(value= {"myCache"}, allEntries=true) //    清空缓存`myCache`下所有缓存数据
        @CacheEvict(value= {"myCache"}, key = "#id")  //   清空缓存`myCache`下key为id的缓存数据
        参考地址：https://www.jb51.net/program/316942jhf.htm
        */
    @CacheEvict(value= {"myCache"}, allEntries=true)
    public List<Book> findAll() {
        return this.baseMapper.selectList(null);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
/*
    @Cacheable(value = "myCache", key = "#id", unless = "#result == null") 生成换成数据，如果为空则不缓存
    myCache为缓存的名称，key为缓存的key，unless为条件，如果为空则不缓存
    使用时与@CacheEvict配合使用，参考地址： https://www.cnblogs.com/huangdh/p/17775887.html
    1. 添加依赖
            <!-- 缓存依赖 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-cache</artifactId>
        </dependency>
    2. 在启动类上添加@EnableCaching注解
    3. 在需要缓存的方法上添加@Cacheable注解
    4. 在需要清除缓存的方法上添加@CacheEvict注解
    */
    @Cacheable(value = "myCache", key = "#id", condition = "#result != null")
    public Book findById(Integer id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    @Cacheable(value = "book",key = "#name")
    public List<Book> findByName(String name) {
        return bookMapper.findByName(name);
    }

    @Override
    public List<Book> selectName(String name, String name1) {
        return bookMapper.selectName(name,name1);
    }

    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        cachedDataList.add(demoData);
    }

    @Override
    public List<Book> likeTest(String name) {
      return   this.baseMapper.selectList(new QueryWrapper<Book>().notLike("name", name+"%"));
    }

//    @Override
//    public List<Book> findAllTest() {
//        return bookService.findAllTest();
//    }

    @Override
    public boolean updateById(Book entity) {
        try {
            this.bookMapper.insert(entity);
            int a = 1 / 0;
        } catch (Exception e) {
            throw new RuntimeException("异常");
        }finally {
            findAll();
        }

        return true;

    }

}




