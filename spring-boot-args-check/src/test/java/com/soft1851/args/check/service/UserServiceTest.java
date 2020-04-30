package com.soft1851.args.check.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soft1851.args.check.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.*;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/30
 * @Version 1.0
 */
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @ExceptionHandler(ConstraintViolationException.class)
    void validatePerson() throws Exception {
        User user = new User();
        user.setId("123456");
        user.setName("Soft1851");
        user.setAge(19);
        user.setPhone("111111111111");
        user.setEmail("Soft1851@qq.com");
        user.setSex("Man");
        user.setRegion("China");
        userService.validatePerson(user);
    }

    @Test
    void checkManually() {
        //通过 Validator 工厂类获得的 Validator实例， 也可以通过注入的方式
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        User user = new User();
        user.setId("123");
        user.setSex("Man22");
        user.setEmail("abc");
        // 对参数进行校验，得到一组结果
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> constraintViolation : violations) {
            System.out.println(constraintViolation.getMessage());
        }
    }
}