package com.example.newtest;

import com.example.newtest.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NewTestApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testRedis(){
        redisUtil.set("name","张三");
    }
}
