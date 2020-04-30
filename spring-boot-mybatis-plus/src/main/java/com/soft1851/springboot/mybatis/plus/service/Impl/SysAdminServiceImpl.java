package com.soft1851.springboot.mybatis.plus.service.impl;

import com.soft1851.springboot.mybatis.plus.entity.SysAdmin;
import com.soft1851.springboot.mybatis.plus.mapper.SysAdminMapper;
import com.soft1851.springboot.mybatis.plus.mapper.SysMenuMapper;
import com.soft1851.springboot.mybatis.plus.service.SysAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wf
 * @since 2020-04-21
 */
@Service
public class SysAdminServiceImpl extends ServiceImpl<SysAdminMapper, SysAdmin> implements SysAdminService {
    @Resource
    private SysAdminMapper sysAdminMapper;
    @Resource
    private SysMenuMapper menuMapper;

    @Override
    public Map<String, Object> getUserMenuByUserId(String userId) {
        //定义一个map
        Map<String, Object> map = new HashMap<>();
        //得到用户信息及角色信息
        Map<String, Object> admin = sysAdminMapper.getAdminMenuByAdminId(userId);
        //取出用户的角色Id
        int roleId = Integer.parseInt(admin.get("role_id").toString());
        //通过角色Id得到该用户的权限
        List<Map<String, Object>> maps = menuMapper.getParentMenuByRoleId(roleId);
        //移除多余字段
        for (Map<String, Object> map1 : maps) {
            map1.remove("role_id");
            map1.remove("menu_id");
        }
        //将得到的两个集合写入map，返回数据
        map.put("user", admin);
        map.put("permission", maps);
        return map;
    }
}
