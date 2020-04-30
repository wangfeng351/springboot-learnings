package com.soft1851.springboot.mybatis.plus.service;

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
class SysUserServiceTest {
    @Resource
    private SysUserService sysUserService;

    @Test
    void getUserPermissionByUserId() {
        System.out.println(sysUserService.getUserPermissionByUserId("2"));
    }
}