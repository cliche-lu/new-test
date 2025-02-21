package com.cliche.newtest.config.handler;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.cliche.newtest.utils.TenantContext;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.springframework.stereotype.Component;

import static com.cliche.newtest.common.CommonEnum.TENANT_TABLE;


@Component
public class CustomTenantHandler implements TenantLineHandler {

    @Override
    public Expression getTenantId() {
        // 假设有一个租户上下文，能够从中获取当前用户的租户
        // 获取当前租户ID
        String tenantId = TenantContext.getTenantId();
        // 返回租户ID的表达式，LongValue 是 JSQLParser 中表示 bigint 类型的 class
//        TenantContext.clear();
        return new LongValue(tenantId);
    }

    @Override
    public String getTenantIdColumn() {
        return "tenant_id";
    }

    @Override
    public boolean ignoreTable(String tableName) {
        // 根据需要返回是否忽略该表
        for(String temp: TENANT_TABLE){
            if(temp.equalsIgnoreCase(tableName)){
                return true;
            }
        }
        return false;
    }

}
