package com.soft1851.springboot.mybatis.plus.mapper;

import com.baomidou.mybatisplus.annotation.SqlParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/16
 * @Version 1.0
 */
@SpringBootTest
class RolePermissionMapperTest {
    @Resource
    private RolePermissionMapper mapper;

    @Test
    void getRolePermissionByRoleId() {
        System.out.println(mapper.getRolePermissionByRoleId(1));
    }
}