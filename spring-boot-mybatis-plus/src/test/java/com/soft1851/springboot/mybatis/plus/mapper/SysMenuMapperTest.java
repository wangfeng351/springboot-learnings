package com.soft1851.springboot.mybatis.plus.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/21
 * @Version 1.0
 */
@SpringBootTest
class SysMenuMapperTest {
    @Resource
    private SysMenuMapper menuMapper;

    @Test
    void getParentMenuByRoleId() {
        System.out.println(menuMapper.getParentMenuByRoleId(1));
    }

    @Test
    void getChildMenuByRoleId() {
        System.out.println(menuMapper.getChildMenuByRoleId(2, 2));
    }
}