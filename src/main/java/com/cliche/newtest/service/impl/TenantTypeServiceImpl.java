package com.cliche.newtest.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cliche.newtest.enity.TenantType;
import com.cliche.newtest.mapper.TenantTypeMapper;
import com.cliche.newtest.service.TenantTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 93285
* @description 针对表【tenant_type】的数据库操作Service实现
* @createDate 2025-03-05 14:20:24
*/
@Service
public class TenantTypeServiceImpl extends ServiceImpl<TenantTypeMapper, TenantType>
    implements TenantTypeService {

    @Override
    public List<TenantType> getTenantType() {
        return this.baseMapper.selectList(null);
    }
}




