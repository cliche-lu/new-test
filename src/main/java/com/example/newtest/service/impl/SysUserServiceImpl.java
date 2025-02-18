package com.example.newtest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.newtest.common.CommonRedisKeys;
import com.example.newtest.enity.LoginUser;
import com.example.newtest.enity.SysUser;
import com.example.newtest.service.SysUserService;
import com.example.newtest.mapper.SysUserMapper;
import com.example.newtest.utils.GlobalException;
import com.example.newtest.utils.JWTUtils;
import com.example.newtest.utils.RedisUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

/**
 * @author 93285
 * @description 针对表【sys_user】的数据库操作Service实现
 * @createDate 2025-02-14 10:45:49
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public SysUser getUserByUsername(String username, String tenantId) {
        if (redisUtil.hasKey(CommonRedisKeys.USER_INFO + tenantId + username)) {
            return (SysUser) redisUtil.get(CommonRedisKeys.USER_INFO + tenantId + username);
        }
        SysUser sysUser = this.baseMapper.selectOne(
                new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username)
                        .eq(SysUser::getTenantId, tenantId)
        );
        if (sysUser != null) {
            redisUtil.set(CommonRedisKeys.USER_INFO + tenantId + username, sysUser, 60 * 60 * 24);
        }
        return sysUser;
    }

    @Override
    public SysUser getUserByUsername(String username) {
        if (redisUtil.hasKey(CommonRedisKeys.USER_INFO + username)) {
            return (SysUser) redisUtil.get(CommonRedisKeys.USER_INFO + username);
        }
        SysUser sysUser = this.baseMapper.selectOne(
                new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username)
        );
        Assert.isTrue(sysUser != null, "用户不存在");
        Set<String> set = this.baseMapper.getUserRoles(sysUser.getId());
        sysUser.setRoles(set);
        redisUtil.set(CommonRedisKeys.USER_INFO + username, sysUser, 60 * 60 * 24);
        return sysUser;
    }

    @Override
    public String login(String username, String password) {
        SysUser sysUser = this.getUserByUsername(username);
        String token;
        if (sysUser != null) {
            if (sysUser.getPassword().equals(password)) {
                HashMap<String, String> map = new HashMap<>();
                map.put("username", username);
                map.put("tenantId", sysUser.getTenantId());
                map.put("id", sysUser.getId().toString());
                String string = UUID.randomUUID().toString();
                map.put("userId", string);
                token = JWTUtils.getToken(map);
                LoginUser loginUser = new LoginUser();
                BeanUtils.copyProperties(sysUser, loginUser);
                loginUser.setUserId(string);
                redisUtil.set(CommonRedisKeys.USER_LOGIN + string, loginUser, 60 * 60 * 24);
            } else {
                throw new GlobalException("密码错误");
            }
        } else {
            throw new GlobalException("用户不存在");
        }
        return token;
    }
}




