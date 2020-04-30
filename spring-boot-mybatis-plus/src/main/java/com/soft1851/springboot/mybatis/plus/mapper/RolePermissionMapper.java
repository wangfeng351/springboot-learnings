package com.soft1851.springboot.mybatis.plus.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1851.springboot.mybatis.plus.entity.RolePermission;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wf
 * @since 2020-04-16
 */
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    /**
     * 获取角色权限视图
     * @param roleId
     * @return
     */
    List<Map<String, Object>> getRolePermissionByRoleId(int roleId);
}
