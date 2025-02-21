package com.cliche.newtest.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class StringUtils {

    /**
     * 密码存储加密：待实现
     * @param password 密码
     * @return 加密后的密码
     */

    public static String passwordEncoder(String password) {
        //        密码加密
        return new BCryptPasswordEncoder().encode(password);
    }
}
