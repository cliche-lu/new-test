package com.cliche.newtest.utils;

import com.cliche.newtest.common.CommonRedisKeys;
import com.cliche.newtest.enity.LoginUser;
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
