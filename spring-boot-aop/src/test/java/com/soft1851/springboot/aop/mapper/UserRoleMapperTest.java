package com.soft1851.springboot.aop.mapper;

import com.soft1851.springboot.aop.entity.SysRole;
import com.soft1851.springboot.aop.entity.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/13
 * @Version 1.0
 */
@SpringBootTest
class UserRoleMapperTest {
    @Resource
    private UserRoleMapper mapper;

    @Test
    void getUserRole() {
        Map<String, Object> map = mapper.getUserRole("2");
        List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("role");
        System.out.println(list.get(0).get("role_name"));
    }
}