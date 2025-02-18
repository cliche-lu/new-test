package com.example.newtest.mapper;

import com.example.newtest.enity.SysPermission;
import com.example.newtest.enity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

/**
* @author 93285
* @description 针对表【sys_user】的数据库操作Mapper
* @createDate 2025-02-14 10:45:49
* @Entity com.example.newtest.enity.SysUser
*/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    Set<String> getUserRoles(Long id);
}




