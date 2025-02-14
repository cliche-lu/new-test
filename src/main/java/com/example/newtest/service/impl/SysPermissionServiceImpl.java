package com.example.newtest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.newtest.enity.SysPermission;
import com.example.newtest.service.SysPermissionService;
import com.example.newtest.mapper.SysPermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author 93285
* @description 针对表【sys_permission】的数据库操作Service实现
* @createDate 2025-02-14 10:45:35
*/
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission>
    implements SysPermissionService{

}
