package com.soft1851.springboot.mybatis.plus.service.Impl;

import com.soft1851.springboot.mybatis.plus.entity.SysUser;
import com.soft1851.springboot.mybatis.plus.mapper.RolePermissionMapper;
import com.soft1851.springboot.mybatis.plus.mapper.SysUserMapper;
import com.soft1851.springboot.mybatis.plus.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wf
 * @since 2020-04-16
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Resource
    private RolePermissionMapper rolePermissionMapper;
    @Resource
    private SysUserMapper userMapper;

    @Override
    public Map<String, Object> getUserPermissionByUserId(String userId) {
        Map<String, Object> map = userMapper.getUserRolePermissionByUserId(userId);
        int roleId = Integer.parseInt(map.get("role_id").toString());
        List<Map<String, Object>> list = rolePermissionMapper.getRolePermissionByRoleId(roleId);
        if(list != null){
            map.put("permission", list);
        }
        return map;
    }
}
