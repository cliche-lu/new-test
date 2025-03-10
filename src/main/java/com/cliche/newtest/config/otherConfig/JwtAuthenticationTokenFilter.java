package com.cliche.newtest.config.otherConfig;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cliche.newtest.common.CommonRedisKeys;
import com.cliche.newtest.enity.LoginUser;
import com.cliche.newtest.utils.JWTUtils;
import com.cliche.newtest.utils.RedisUtil;
import com.cliche.newtest.utils.SecurityUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.*;

@Configuration
@EnableMethodSecurity
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisUtil redisUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            //放行
            filterChain.doFilter(request, response);
            return;
        }
        //解析token
        String userid;
        try {
            JWTUtils.verify(token);
            DecodedJWT decodedJWT = JWTUtils.DecodedJWT(token);
            Claim claims = decodedJWT.getClaim("userId");
            userid = claims.asString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        //从redis中获取用户信息
        String redisKey = CommonRedisKeys.USER_LOGIN + userid;
//        LoginUser loginUser =  SecurityUtils.getSysUser();
        LoginUser loginUser = (LoginUser) redisUtil.get(redisKey);
        if (Objects.isNull(loginUser)) {
            throw new RuntimeException("用户未登录");
        }
        //存入SecurityContextHolder
        // 获取权限信息封装到Authentication中
        Set<String> permissions = loginUser.getPermissions();
        Set<String> roles = loginUser.getRoles();
//        角色包含`admin`则放行
        if (roles.contains("admin")) {
            //放行
            filterChain.doFilter(request, response);
            return;
        }
        //将permissions转成数组
        Collection<GrantedAuthority> authorities = new HashSet<>();
        for (String role : permissions) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        /*
            将roles转成数组
            角色配置，当接口使用 注解 @PreAuthorize("hasAnyRole('admin')")
            注意：这里需要将roles转成ROLE_开头的字符串，因为Spring Security默认会从ROLE_前缀中获取角色信息
         */
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" +role));
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, loginUser.getPassword(), authorities);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //放行
        filterChain.doFilter(request, response);
    }
}
