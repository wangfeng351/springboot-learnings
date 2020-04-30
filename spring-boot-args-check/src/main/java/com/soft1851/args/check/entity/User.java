package com.soft1851.args.check.entity;

import com.soft1851.args.check.annotation.PhoneNumber;
import com.soft1851.args.check.annotation.Region;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/29
 * @Version 1.0
 */
@Data
public class User {

    @NotNull(message = "id 不能为空")
    /*@Min(6)*/
    private String id;

    /*@Size(max = 30)*/
    @NotNull(message = "name 不能为空")
    private String name;

    @Min(18)
    private Integer age;

    /*@Pattern(regexp = "1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
    @NotBlank(message = "手机号码不能为空")*/
    @PhoneNumber(message = "手机格式、长度不正确")
    private String phone;

    @NotNull(message = "email 不能为空")
    @Email(message = "邮箱格式错误")
    private String email;

    @Pattern(regexp = "((^Man$|^Woman$|^UGM$))", message = "sex 值不在可选范围内")
    @NotNull(message = "sex 不能为空")
    private String sex;

    @Region(message = "Region不在范围内")
    private String region;
}
