package com.example.newtest.utils;

import com.example.newtest.common.CommonRedisKeys;
import com.example.newtest.enity.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SysUserLoginUtils {

    private SysUserLoginUtils() {

    }

    public static LoginUser getLoginUser(RedisUtil redisUtil) {
        String userId = TenantContext.getUserId();
        TenantContext.getUserId();
        return (LoginUser) redisUtil.get(CommonRedisKeys.USER_LOGIN + userId);
    }
}
