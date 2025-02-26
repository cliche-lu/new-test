package com.cliche.newtest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cliche.newtest.common.CommonRedisKeys;
import com.cliche.newtest.enity.LoginUser;
import com.cliche.newtest.enity.SysUser;
import com.cliche.newtest.enity.vo.SysUserVo;
import com.cliche.newtest.service.SysUserService;
import com.cliche.newtest.mapper.SysUserMapper;
import com.cliche.newtest.utils.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

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
        Set<String> userRoles = this.baseMapper.getUserRoles1(sysUser.getId());
        sysUser.setRoles(userRoles);
        redisUtil.set(CommonRedisKeys.USER_INFO + username, sysUser, 60 * 60 * 24);
        return sysUser;
    }

    @Override
    public String login(String username, String password) {
        SysUser sysUser = this.getUserByUsername(username);
        String token;
        if (sysUser != null) {
            boolean matches = new CustomMd5PasswordEncoder().matches(password, sysUser.getPassword());
            if (matches) {
//                if (redisUtil.hasKey(CommonRedisKeys.USER_LOGIN + sysUser.getUserId())) {
//                    throw new GlobalException("用户已在其他地方登录！");
//                }
                HashMap<String, String> map = new HashMap<>();
                map.put("username", username);
                map.put("tenantId", sysUser.getTenantId());
                map.put("id", sysUser.getId().toString());
                String userId = sysUser.getUserId();
                map.put("userId", userId);
                token = JWTUtils.getToken(map);
                LoginUser loginUser = new LoginUser();
                BeanUtils.copyProperties(sysUser, loginUser);
                loginUser.setUserId(userId);
                redisUtil.set(CommonRedisKeys.USER_LOGIN + userId, loginUser, 60 * 60 * 2);
            } else {
                throw new GlobalException("密码错误");
            }
        } else {
            throw new GlobalException("用户不存在");
        }
        return token;
    }

    @Override
    public LoginUser getNowLoginUser() {
        return SysUserLoginUtils.getLoginUser(redisUtil);
    }
    @Override
    public LoginUser getNowLoginUser1() {
        return SecurityUtils.getSysUser();
    }

    @Override
    public void loginOut(String username) {
        LoginUser loginUser = SysUserLoginUtils.getLoginUser(redisUtil);
        if (redisUtil.hasKey(CommonRedisKeys.USER_LOGIN + loginUser.getUserId())) {
            redisUtil.del(CommonRedisKeys.USER_LOGIN + loginUser.getUserId());
        }
    }

    @Override
    public List<SysUserVo> getUserList() {
        LoginUser sysUser = SecurityUtils.getSysUser();
        return this.baseMapper.getUserList(sysUser.getTenantId());
    }
}




