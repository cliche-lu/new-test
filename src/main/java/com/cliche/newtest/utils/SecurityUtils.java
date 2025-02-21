package com.cliche.newtest.utils;

import com.cliche.newtest.enity.LoginUser;
import com.cliche.newtest.enity.SysUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import com.cliche.newtest.enity.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Set;


/**
 * 安全服务工具类
 *
 * @author harry
 * @公众号 Harry技术
 */
public class SecurityUtils {


    public static UserDetails getUserDetails() {
        try {
            return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new GlobalException("暂未登录或token已失效");
        }
    }

    public static SysUserDetails getSysUserDetails() {
        try {
            return (SysUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new GlobalException("暂未登录或token已失效");
        }
    }

    /**
     * 是否超级管理员
     * <p>
     * 超级管理员忽视任何权限判断
     */
    public static boolean isRoot() {
        Set<String> roles = getRoles();
        return roles.contains("root");
    }

    /**
     * 获取当前 用户id
     *
     * @return 用户id
     */
    public static Long getUserId() {
        return getSysUser().getId();
    }


    public static Set<String> getRoles() {
        return getSysUserDetails().getRoles();
    }

    public static LoginUser getSysUser() {
        try {
            SecurityContext ctx = SecurityContextHolder.getContext();
            Authentication auth = ctx.getAuthentication();
            return (LoginUser) auth.getPrincipal();
        } catch (Exception e) {
            throw new GlobalException("暂未登录或token已失效");
        }
    }

    public static SysUser getSysUserIsNull() {
        try {
            SecurityContext ctx = SecurityContextHolder.getContext();
            Authentication auth = ctx.getAuthentication();
            SysUserDetails sysUserDetails = (SysUserDetails) auth.getPrincipal();
            return sysUserDetails.getSysUser();
        } catch (Exception e) {
           return null;
        }
    }

    public static Integer getDataScope() {
        return  getSysUserDetails().getDataScope();
    }

    public static Long getDeptId() {
        return getSysUserDetails().getSysUser().getDeptId();
    }
}
