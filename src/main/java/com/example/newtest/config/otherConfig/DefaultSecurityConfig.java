package com.example.newtest.config.otherConfig;


import com.example.newtest.utils.CustomMd5PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

@EnableWebSecurity
@Configuration
public class DefaultSecurityConfig {
    /**
     * 密码明文加密方式配置
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new CustomMd5PasswordEncoder();
    }

    /**
     * 获取AuthenticationManager（认证管理器），登录时认证使用
     * @param authenticationConfiguration
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // 禁用 CSRF 保护
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // 配置 CORS
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/V1/login").permitAll() // 允许所有用户访问登录接口
                        .requestMatchers(HttpMethod.GET, "/", "/*.html", "/**.html", "/**.css", "/**.js", "/profile/**").permitAll() // 允许匿名访问静态资源
                        .requestMatchers("/swagger-ui.html", "/swagger-resources/**", "/webjars/**", "/*/api-docs", "/druid/**").permitAll() // 允许匿名访问 Swagger 和 Druid
                        .anyRequest().authenticated() // 其他请求都需要身份验证
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // 基于 token，不需要 session
        // 添加其他安全配置...
        ;
        return http.build();
    }

    /**
     * 配置跨源访问(CORS)
     * @return
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
