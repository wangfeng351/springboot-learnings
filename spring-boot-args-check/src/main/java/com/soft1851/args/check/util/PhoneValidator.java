package com.soft1851.args.check.util;

import com.soft1851.args.check.annotation.PhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/30
 * @Version 1.0
 */
public class PhoneValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        // 验证手机号
        Pattern p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
        return p.matcher(s).matches();
    }
}
