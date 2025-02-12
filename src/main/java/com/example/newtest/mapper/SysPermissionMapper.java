package com.example.newtest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.newtest.enity.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import javax.swing.tree.TreeModel;
import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @Author scott
 * @since 2018-12-21
 */
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

}
