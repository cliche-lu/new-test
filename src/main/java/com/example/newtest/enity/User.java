package com.example.newtest.enity;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
//自动生成元数据，自动注入
@ConfigurationProperties(prefix = "mytest")
public class User {
    private String name;
    private String age;
}
