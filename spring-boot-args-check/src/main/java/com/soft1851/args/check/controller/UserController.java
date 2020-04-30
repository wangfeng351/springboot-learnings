package com.soft1851.args.check.controller;

import com.soft1851.args.check.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * @Description 使用spring框架自带的ResponseEntity作为返回值
 * @Author wf
 * @Date 2020/4/30
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/api")
@Validated
public class UserController {

    @PostMapping(value = "/user")
    public ResponseEntity<User> saveUser(@RequestBody @Valid User user) {
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "user/{id}")
    public ResponseEntity<Integer> getUserById(@Valid @PathVariable("id") @Min(value = 6, message = "id长度不足") int id) {
        return ResponseEntity.ok().body(id);
    }

    @GetMapping("/user")
    public ResponseEntity<String> getUserByName(@Valid @RequestParam("name") @Size(max = 6, message = "name长度超出范围") String name) {
        return ResponseEntity.ok().body(name);
    }

}
