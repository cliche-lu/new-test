package com.cliche.newtest.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cliche.newtest.enity.BusinessTable;
import com.cliche.newtest.service.BusinessTableService;
import com.cliche.newtest.mapper.BusinessTableMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author 93285
 * @description 针对表【business_table】的数据库操作Service实现
 * @createDate 2025-02-14 10:44:10
 */
@Service
public class BusinessTableServiceImpl extends ServiceImpl<BusinessTableMapper, BusinessTable>
        implements BusinessTableService {

    @Override
    public List<BusinessTable> listPage(BusinessTable businessTable) {
        return this.baseMapper.selectList(getWrapper(businessTable));
    }

    private Wrapper<BusinessTable> getWrapper(BusinessTable businessTable) {
        LambdaUpdateWrapper<BusinessTable> businessTableLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        if (businessTable != null) {
            businessTableLambdaUpdateWrapper.like(StringUtils.hasLength(businessTable.getUsers()), BusinessTable::getUsers, businessTable.getUsers());
            businessTableLambdaUpdateWrapper.like(StringUtils.hasLength(businessTable.getRemark()), BusinessTable::getRemark, businessTable.getRemark());
            businessTableLambdaUpdateWrapper.like(StringUtils.hasLength(businessTable.getAddress()), BusinessTable::getAddress, businessTable.getAddress());
            businessTableLambdaUpdateWrapper.like(StringUtils.hasLength(businessTable.getOthers()), BusinessTable::getOthers, businessTable.getOthers());

        }
        return businessTableLambdaUpdateWrapper;
    }


}




