package com.example.newtest.mapper;

import com.example.newtest.enity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Hades
* @description 针对表【book】的数据库操作Mapper
* @createDate 2023-09-25 17:18:30
* @Entity com.example.newtest.domain.Book
*/
@Mapper
public interface BookMapper extends BaseMapper<Book> {

    List<Book> findByName(@Param("name") String name);

    List<Book> selectName(@Param("name")String name,@Param("name1") String name1);
    /*
    Mybatis in 条件传参三种实现方法（直接$，List，[]）
    使用数组去传参，sql中拼接in**
    select * from table_name where name in **
     https://blog.csdn.net/wh445306/article/details/111056331
     */
}




