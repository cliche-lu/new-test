package com.example.newtest.enity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Auther: 93285
 * @Date: 2024/1/4
 * @Description: test
 * @PROJECT_NAME: cliche
 * @Package_name: IntelliJ IDEA
 **/
@Getter
@Setter
@EqualsAndHashCode
public class DemoData {
    /**
     * 强制读取第三个 这里不建议 index 和 name 同时用，要么一个对象只用index，要么一个对象只用name去匹配
     */
//    @ExcelProperty("字符串")
    private String string;
    /**
     * 用名字去匹配，这里需要注意，如果名字重复，会导致只有一个字段读取到数据
     */
    @ExcelProperty("字符串标题")
    private String date;
    @ExcelProperty("*日期标题")
    private Double doubleData;

    @ExcelProperty("图片")
    private String img;
}