package com.example.newtest.config.handler;


import com.baomidou.mybatisplus.extension.plugins.handler.MultiDataPermissionHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.example.newtest.enity.LoginUser;
import com.example.newtest.service.SysUserService;
import com.example.newtest.utils.RedisUtil;
import com.example.newtest.utils.SysUserLoginUtils;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.security.GeneralSecurityException;

@Component
public class CustomDataPermissionHandler implements MultiDataPermissionHandler, InnerInterceptor {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Expression getSqlSegment(Table table, Expression where, String mappedStatementId) {
        // 在此处编写自定义数据权限逻辑
        try {
            LoginUser loginUser = SysUserLoginUtils.getLoginUser(redisUtil);
            Assert.isTrue(loginUser != null, "用户未登录!");
            String sqlSegment = ""; // 数据权限相关的 SQL 片段
            if (!table.getName().startsWith("sys_")) {
                // 如果表名以 "sys_" 开头，则添加数据权限相关的 SQL 片段
                if (!"admin".equals(loginUser.getUsername())) {
                    sqlSegment = "create_by = '" + loginUser.getUsername() + "'";
                }
            }
            return CCJSqlParserUtil.parseCondExpression(sqlSegment);
        } catch (JSQLParserException e) {
            e.printStackTrace();
            return null;
        }
    }
}
