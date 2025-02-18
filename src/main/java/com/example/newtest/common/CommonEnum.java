package com.example.newtest.common;

import java.util.ArrayList;
import java.util.List;

public class CommonEnum {

    private CommonEnum() {

    }

    public static final String SUCCESS = "success";

    public static final List<String> TENANT_TABLE = new ArrayList<>();

    static {
        TENANT_TABLE.add("demo");
        TENANT_TABLE.add("sys_permission");
        TENANT_TABLE.add("sys_role");
        TENANT_TABLE.add("sys_user");
        TENANT_TABLE.add("sys_user_role");
        TENANT_TABLE.add("sys_role_permission");

    }
}
