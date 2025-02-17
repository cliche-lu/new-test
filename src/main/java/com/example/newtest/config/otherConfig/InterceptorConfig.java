package com.example.newtest.config.otherConfig;

import com.example.newtest.config.handler.JWTInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @Description: 攔截器
 * @deprecated 使用`Security`的拦截器
 */
//@Component
public class InterceptorConfig implements WebMvcConfigurer {

//   @Autowired
   private JWTInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/**")
                .excludePathPatterns("/V1/login")
                .excludePathPatterns("/sysUser/add")
        ;

    }

    /**
     * 跨域配置
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOriginPatterns("*").allowedMethods("*").allowedHeaders("*").maxAge(3600).allowCredentials(true);
    }
}
