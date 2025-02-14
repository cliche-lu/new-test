package com.example.newtest;

import org.mybatis.spring.annotation.MapperScan;
import org.simpleframework.xml.core.Validate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * easy excel 待研究
 * <a href="https://easyexcel.opensource.alibaba.com/docs/current/quickstart/read#">文档地址</a>
 * <a href="https://github.com/alibaba/easyexcel/blob/master/easyexcel-test/src/test/java/com/alibaba/easyexcel/test/demo/read/ReadTest.java">demo地址</a>
 */
@SpringBootApplication
@RestController
@EnableCaching
public class NewTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewTestApplication.class, args);
    }

    /**
     * 获取配置文件测试
     */
    @Value("${test}")
    public String tets;

    @GetMapping("/")
    public String spring() {

        return "hello word!"+tets;
    }

}
