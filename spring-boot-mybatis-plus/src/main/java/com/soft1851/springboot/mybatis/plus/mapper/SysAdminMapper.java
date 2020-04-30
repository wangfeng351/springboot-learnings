package com.soft1851.springboot.mybatis.plus.mapper;

import com.soft1851.springboot.mybatis.plus.entity.SysAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wf
 * @since 2020-04-21
 */
public interface SysAdminMapper extends BaseMapper<SysAdmin> {

    /**
     * 通过adminId获取对应权限
     * @param adminId
     * @return
     */
    Map<String, Object> getAdminMenuByAdminId(String adminId);
}
