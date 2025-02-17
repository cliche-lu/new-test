package com.example.newtest.config.otherConfig;

import cn.hutool.jwt.Claims;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.newtest.enity.LoginUser;
import com.example.newtest.utils.JWTUtils;
import com.example.newtest.utils.RedisUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
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
        String redisKey = "login:" + userid;
        LoginUser loginUser = (LoginUser) redisUtil.get(redisKey);
        if(Objects.isNull(loginUser)){
            throw new RuntimeException("用户未登录");
        }
        //存入SecurityContextHolder
        //TODO 获取权限信息封装到Authentication中
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser,null,null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //放行
        filterChain.doFilter(request, response);
    }
}
