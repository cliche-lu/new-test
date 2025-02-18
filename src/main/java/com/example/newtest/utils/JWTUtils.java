package com.example.newtest.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class JWTUtils {
    private static String SIGNATURE = "token!@#$%^7890";

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 生成token
     *
     * @param map //传入payload
     * @return 返回token
     */
    public static String getToken(Map<String, String> map) {
        if (map.isEmpty()) {
            throw new RuntimeException("token创建失败");
        }
        JWTCreator.Builder builder = JWT.create();
        map.forEach(builder::withClaim);
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 60 * 60 * 2);
        builder.withExpiresAt(instance.getTime());
        return builder.sign(Algorithm.HMAC256(SIGNATURE));
    }

    /**
     * 验证token
     *
     * @param token
     */
    public static void verify(String token) {
        JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
        DecodedJWT decodedJWT = DecodedJWT(token);
        Claim username = decodedJWT.getClaim("username");
        if (username == null) {
            throw new RuntimeException("token无效");
        }
        Claim userId = decodedJWT.getClaim("userId");
        if (userId == null) {
            throw new RuntimeException("token无效");
        }
        Claim tenantId = decodedJWT.getClaim("tenantId");
        if (tenantId == null) {
            throw new RuntimeException("token无效");
        }
        Claim id = decodedJWT.getClaim("id");
        if (id == null) {
            throw new RuntimeException("token无效");
        }
//        租户给值
        TenantContext.setTenantId(tenantId.asString());
        TenantContext.setUserId(userId.asString());
        TenantContext.setUsername(username.asString());

    }

    /**
     * 获取token中payload
     *
     * @param token
     * @return
     */
    public static DecodedJWT DecodedJWT(String token) {
        return JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
    }
//    public Claim getClaim(String payload) {
//        return this.payload.getClaim(name);
//    }



    public static void main(String[] args) {
//        verify(null);
        Map<String, String> map1 = new HashMap<>();
        map1.put("userId", "1");
        map1.put("username", "admin");
//        map1.put("password", "123456");
        String token = JWTUtils.getToken(map1);
        System.out.println("JWTUtils.getToken(map1) = " + token);
        DecodedJWT decodedJWT = DecodedJWT(token);
        Claim payload = decodedJWT.getClaim("jwtId");
//        String payload = decodedJWT.getPayload().;
        Claim userKey = decodedJWT.getClaim("user_key");
        Map<String, Object> map = userKey.asMap();
        String string = userKey.asString();
        System.out.println("decodedJWT = " + userKey);
    }
}
