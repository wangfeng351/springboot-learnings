package com.soft1851.springboot.mybatis.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.soft1851.springboot.mybatis.plus.mapper")
@ComponentScan("com.soft1851.springboot.mybatis.plus.service")
@ComponentScan("com.soft1851.springboot.mybatis.plus.controller")
public class SpringBootMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisPlusApplication.class, args);
    }

}
