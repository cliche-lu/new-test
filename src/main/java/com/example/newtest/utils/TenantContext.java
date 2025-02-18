package com.example.newtest.utils;

/**
 * <a href="https://blog.51cto.com/u_16213420/12646542">参考地址</a>
 * 租户上下文
 * 使用`ThreadLocal`做租户上下文
 */
public class TenantContext {
    private static final ThreadLocal<String> tenantId = new ThreadLocal<>();

    // 设置租户ID
    public static void setTenantId(String id) {
        tenantId.set(id);
    }

    // 获取租户ID
    public static String getTenantId() {
        return tenantId.get();
    }

    // 清除租户ID
    public static void clear() {
        tenantId.remove();
    }

    private static final ThreadLocal<String> userId = new ThreadLocal<>();

    // 设置租户ID
    public static void setUserId(String id) {
        userId.set(id);
    }

    // 获取租户ID
    public static String getUserId() {
        return userId.get();
    }

    // 清除租户ID
    public static void clearUserId() {
        userId.remove();
    }

}
