package com.cliche.newtest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cliche.newtest.enity.SysPermission;
import com.cliche.newtest.service.SysPermissionService;
import com.cliche.newtest.mapper.SysPermissionMapper;
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
