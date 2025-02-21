package com.cliche.newtest.config.handler;


import com.baomidou.mybatisplus.extension.plugins.handler.MultiDataPermissionHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;

import com.cliche.newtest.utils.TenantContext;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Table;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Component
@Slf4j
public class CustomDataPermissionHandler implements MultiDataPermissionHandler, InnerInterceptor {

    @Override
    public Expression getSqlSegment(Table table, Expression where, String mappedStatementId) {
        // 在此处编写自定义数据权限逻辑
//        log.info("---------进入数据权限----");
        try {
            String sqlSegment = ""; // 数据权限相关的 SQL 片段
            if (!table.getName().startsWith("sys_")) {
                String username = TenantContext.getUsername();
                Assert.isTrue(StringUtils.hasLength(username), "用户未登录!");
                // 如果表名不以 "sys_" 开头，则添加数据权限相关的 SQL 片段
                //                    此处可以给业务表中加一个共享类型字段：owen/all/其他
                if (!"admin".equals(username)) {
//                    业务表`business_table`的内容处理
                    if (table.getName().equals("business_table")) {
                        sqlSegment = "(" + "create_by = '" + username + "'"
                                + "or share = 'all'"
                                + "or share like '" + username + ",%'"
                                + "or share like '%," + username + ",%'"
                                + "or share like '%," + username + "'"
                                + ")";
                    }
                }
            }
//            log.info("---------进入数据权限返回sql字符串---- ：{}", sqlSegment);
            return CCJSqlParserUtil.parseCondExpression(sqlSegment);
        } catch (JSQLParserException e) {
            e.printStackTrace();
            return null;
        }
    }
}
