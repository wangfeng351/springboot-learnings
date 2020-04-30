package com.soft1851.springboot.aop.service;

import com.soft1851.springboot.aop.entity.SysUser;
import com.soft1851.springboot.aop.entity.UserRole;

import java.util.List;
import java.util.Map;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-04-13 19:51:04
 */
public interface SysUserService {

    /**
     * 用户登录
     *
     * @param id
     * @param password
     * @return
     */
    Map<String, Object> signIn(String id, String password);

}