package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.AuthToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/14
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @AuthToken
    @GetMapping("/test")
    public String get(String name) {
        System.out.println(name);
        return "goodBye";
    }
}
