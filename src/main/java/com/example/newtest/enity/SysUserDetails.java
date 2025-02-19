package com.example.newtest.enity;

import cn.hutool.core.util.StrUtil;
import com.example.newtest.common.StatusEnums;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * SpringSecurity 自定义用户详情
 *
 * @author harry
 * @公众号 Harry技术
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"enabled", "accountNonExpired", "accountNonLocked", "credentialsNonExpired", "authorities", "password"})
public class SysUserDetails implements UserDetails {
    private String username;

    private SysUser sysUser;

    private Set<String> permissions;

    private List<SysPermission> roles;

    private Integer dataScope;


    public SysUserDetails(SysUser user, Set<String> permissions, List<SysPermission> roles, String username, Integer dataScope) {
        this.sysUser = user;
        this.permissions = permissions;
        this.roles = roles;
        this.username = username;
        this.dataScope = dataScope;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 返回当前用户的权限
        return permissions.stream().filter(StrUtil::isNotEmpty)
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    /**
     * 是否可用 ,禁用的用户不能身份验证
     *
     * @return 是否可用
     */
    @Override
    public boolean isEnabled() {
        return StatusEnums.ENABLE.getKey().equals(sysUser.getStatus());
    }

}
