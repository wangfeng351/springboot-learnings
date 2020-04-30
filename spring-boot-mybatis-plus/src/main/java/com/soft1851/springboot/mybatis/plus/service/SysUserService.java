package com.soft1851.springboot.mybatis.plus.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.soft1851.springboot.mybatis.plus.entity.SysUser;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wf
 * @since 2020-04-16
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 获取用户的权限
     * @param userId
     * @return
     */
    Map<String, Object> getUserPermissionByUserId(String userId);
}
