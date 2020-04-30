package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.entity.SysUser;
import com.soft1851.springboot.aop.entity.UserRole;
import com.soft1851.springboot.aop.service.SysUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2020-04-13 19:51:04
 */
@RestController
@RequestMapping(value = "/sysUser")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @PostMapping("/login")
    public Map<String, Object> signIn(@Param("id") String id, @Param("password") String password) {
        return sysUserService.signIn(id, password);
    }

}