package com.cliche.newtest.config.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.cliche.newtest.enity.LoginUser;
import com.cliche.newtest.utils.RedisUtil;
import com.cliche.newtest.utils.SecurityUtils;
import com.cliche.newtest.utils.SysUserLoginUtils;
import com.cliche.newtest.utils.TenantContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("开始插入填充...");
        String tenantId = TenantContext.getTenantId();
        String username = TenantContext.getUsername();
        TenantContext.clear();
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "delFlag", Integer.class, 0);
        this.strictInsertFill(metaObject, "reversion", Integer.class, 0);
        this.strictInsertFill(metaObject, "createBy", String.class, username);
        this.strictInsertFill(metaObject, "tenantId", String.class, tenantId);
        TenantContext.clear();
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("开始更新填充...");
        LoginUser loginUser = SysUserLoginUtils.getLoginUser(redisUtil);
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
        this.strictUpdateFill(metaObject, "updateBy", String.class, loginUser.getUsername());
    }
}
