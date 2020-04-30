package com.soft1851.springboot.mybatis.plus.service;

import com.soft1851.springboot.mybatis.plus.entity.SysAdmin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wf
 * @since 2020-04-21
 */
public interface SysAdminService extends IService<SysAdmin> {

    /**
     * 获取用户的权限
     * @param userId
     * @return
     */
    Map<String, Object> getUserMenuByUserId(String userId);
}
