package com.soft1851.springboot.aop.mapper;

import com.soft1851.springboot.aop.entity.RolePermission;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/13
 * @Version 1.0
 */
public interface RolePermissionMapper {

    /**
     * 根据角色id查询角色
     *
     * @param id
     * @return
     */
    @Results({
            @Result(property = "permission", column = "permission_id",
                    one = @One(select = "com.soft1851.springboot.aop.mapper.SysPermissionMapper.getChildPermissionById")),
    })
    @Select("SELECT * FROM role_permission WHERE role_id=#{id}")
    List<Map<String, Object>> getRoleById(int id);
}
