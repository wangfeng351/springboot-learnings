package com.soft1851.springboot.mybatis.plus.controller;


import com.soft1851.springboot.mybatis.plus.common.ResponseResult;
import com.soft1851.springboot.mybatis.plus.service.SysAdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wf
 * @since 2020-04-21
 */
@RestController
@RequestMapping(value = "/sysAdmin")
public class SysAdminController {
    @Resource
    private SysAdminService sysAdminService;

    @GetMapping(value = "/list/m")
    public ResponseResult getUserMenuByUserId(String userId){
        return ResponseResult.success(sysAdminService.getUserMenuByUserId(userId));
    }
}
