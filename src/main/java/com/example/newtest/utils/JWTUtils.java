package com.example.newtest.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Map;
import java.util.UUID;

@Component
public class JWTUtils {
    private static String SIGNATURE = "token!@#$%^7890";

    /**
     * 生成token
     *
     * @param map //传入payload
     * @return 返回token
     */
    public String getToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();
        map.forEach(builder::withClaim);
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 60 * 60 * 24);
        builder.withExpiresAt(instance.getTime());
        String string = UUID.randomUUID().toString();
        builder.withClaim(map.get("userId"), string);
        builder.withJWTId(string);
        return builder.sign(Algorithm.HMAC256(SIGNATURE));
    }

    /**
     * 验证token
     *
     * @param token
     */
    public static void verify(String token) {
        JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
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
        DecodedJWT decodedJWT = DecodedJWT("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2tleSI6IjM3OTcyNDk0LWU0YjEtNDFmNi1iY2IxLTEyNGEwZDE0ZjNjOSIsInVzZXJSb2xlIjoiOSIsImV4cCI6MTcxNDU0MDYzOSwidXNlcklkIjoiMSIsImp0aSI6IjM3OTcyNDk0LWU0YjEtNDFmNi1iY2IxLTEyNGEwZDE0ZjNjOSIsInVzZXJuYW1lIjoiYWRtaW4ifQ.lDsOSoL18GtEvZe8IyZj8kB7RMWdEyF4PEpDRRAIYZ4");
        Claim payload = decodedJWT.getClaim("jwtId");
//        String payload = decodedJWT.getPayload().;
        Claim userKey = decodedJWT.getClaim("user_key");
        Map<String, Object> map = userKey.asMap();
        String string = userKey.asString();
        System.out.println("decodedJWT = " + userKey);
    }
}
