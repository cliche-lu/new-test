package com.cliche.newtest;

import com.cliche.newtest.mapper.SysUserMapper;
import com.cliche.newtest.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NewTestApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void testRedis(){
        redisUtil.set("name","张三");
    }

    @Test
    public void testMybatisPlus(){
        Set<String> userRoles = sysUserMapper.getUserRoles(1L);
        System.out.println("userRoles = " + userRoles);
    }
}
