package com.soft1851.springboot.mybatis.plus.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1851.springboot.mybatis.plus.entity.SysUser;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wf
 * @since 2020-04-16
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 查询该用户的角色及权限
     * @param userId
     * @return
     */
    Map<String, Object> getUserRolePermissionByUserId(String userId);
}
