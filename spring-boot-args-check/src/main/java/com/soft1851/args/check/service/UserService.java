package com.soft1851.args.check.service;

import com.soft1851.args.check.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/30
 * @Version 1.0
 */
@Service
@Validated
@Slf4j
public class UserService {
    public void validatePerson(@Valid User user) {
        log.info("service方法验证");
    }
}
