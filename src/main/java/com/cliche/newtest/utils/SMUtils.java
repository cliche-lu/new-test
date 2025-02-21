package com.cliche.newtest.utils;

import cn.hutool.crypto.SmUtil;

import java.nio.charset.StandardCharsets;

/**
 * enfi 西南铜项目中前端加密的算法
 */
public class SMUtils {

    public final static String SM4_SECRET = "f7beda505448741f";

    public final static String SM4_DATA_SECRET = "ad5aa4601acb4613";

    public static String encrypt(String data) {
        return SmUtil.sm4(SM4_SECRET.getBytes(StandardCharsets.UTF_8)).encryptBase64(data);
    }

    public static String decrypt(String data) {
        return SmUtil.sm4(SM4_SECRET.getBytes(StandardCharsets.UTF_8)).decryptStr(data);
    }

    public static String dataEncrypt(String data) {
        return SmUtil.sm4(SM4_DATA_SECRET.getBytes(StandardCharsets.UTF_8)).encryptBase64(data);
    }

    public static String dataDecrypt(String data) {
        return SmUtil.sm4(SM4_DATA_SECRET.getBytes(StandardCharsets.UTF_8)).encryptBase64(data);
    }

    public static void main(String[] args) {
        System.out.println(encrypt("10086"));
        System.out.println(encrypt("10086P@ssword1"));
    }
}
