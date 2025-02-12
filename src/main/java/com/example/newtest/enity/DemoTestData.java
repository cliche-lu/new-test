package com.example.newtest.enity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: 93285
 * @Date: 2024/1/4
 * @Description: test
 * @PROJECT_NAME: cliche
 * @Package_name: IntelliJ IDEA
 **/
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class DemoTestData {

    @ExcelProperty("*字符串")
    private String string;
    @ExcelProperty("zz")
    private String zz;
}