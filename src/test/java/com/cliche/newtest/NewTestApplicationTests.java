package com.cliche.newtest;

import com.cliche.newtest.enity.TenantType;
import com.cliche.newtest.mapper.SysUserMapper;
import com.cliche.newtest.service.TenantTypeService;
import com.cliche.newtest.utils.CustomMd5PasswordEncoder;
import com.cliche.newtest.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NewTestApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private TenantTypeService tenantTypeService;

@Test
    public void test3(){
    List<TenantType> tenantType = tenantTypeService.getTenantType();
    System.out.println("tenantType = " + tenantType);
}
    @Test
    public void test2(){
        boolean matches1 = new CustomMd5PasswordEncoder().matches("123456","[-31, 10, -36, 57, 73, -70, 89, -85, -66, 86, -32, 87, -14, 15, -120, 62]");
        System.out.println("matches1 = " + matches1);
    }
    @Test
    public void test1() {
        BigDecimal bigDecimal = new BigDecimal("10000.12");
        BigDecimal divide = bigDecimal.divide(BigDecimal.valueOf(3), RoundingMode.CEILING);
        System.out.println("divide = " + divide);
        BigDecimal moneyTotal = new BigDecimal("1730751.00");
        BigDecimal amountTotalT = new BigDecimal("3649.2");
//        BigDecimal price = moneyTotal.divide(amountTotalT, RoundingMode.CEILING);
        BigDecimal price =  moneyTotal.divide(amountTotalT).setScale(2, RoundingMode.HALF_UP);;


        System.out.println("价格： " + price); // 输出前7天的日期

    }

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
