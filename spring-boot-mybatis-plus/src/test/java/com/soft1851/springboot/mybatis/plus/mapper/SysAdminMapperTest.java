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
class SysAdminMapperTest {
    @Resource
    private SysAdminMapper mapper;

    @Test
    void getAdminMenuByAdminId() {
        System.out.println(mapper.getAdminMenuByAdminId("DE35D7CC05AF96A21D7ADFC8651E6614"));
    }
}