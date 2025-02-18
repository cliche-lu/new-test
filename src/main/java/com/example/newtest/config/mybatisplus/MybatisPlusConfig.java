package com.example.newtest.config.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.DataPermissionInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import com.example.newtest.config.handler.CustomDataPermissionHandler;
import com.example.newtest.config.handler.CustomTenantHandler;
import org.checkerframework.checker.units.qual.A;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.newtest.mapper.**")
public class MybatisPlusConfig {

    @Autowired
    private CustomTenantHandler customTenantHandler;

    @Autowired
    private CustomDataPermissionHandler customDataPermissionHandler;

    /**
     * 添加分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        乐观锁插件 TODO 此插件存在问题，待排查处理
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
//        多租户插件
        /*
            多租户不等于权限过滤，租户之间是完全隔离的。
            启用多租户后，所有执行的 method 的 SQL 都会进行处理。
            自定义的 SQL 请按规范书写，特别是涉及到多个表的每个表都要给别名，特别是 inner join 的要写标准的 inner join。
         */
        TenantLineInnerInterceptor tenantInterceptor = new TenantLineInnerInterceptor();
        tenantInterceptor.setTenantLineHandler(customTenantHandler);
        interceptor.addInnerInterceptor(tenantInterceptor);
//        数据权限插件 存在疑惑，待处理
        interceptor.addInnerInterceptor(customDataPermissionHandler);
//        分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL)); // 如果配置多个插件, 切记分页最后添加
        // 如果有多数据源可以不配具体类型, 否则都建议配上具体的 DbType
        return interceptor;
    }

}
