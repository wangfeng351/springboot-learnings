package com.soft1851.args.check.util;

import com.soft1851.args.check.annotation.Region;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/30
 * @Version 1.0
 */
public class RegionValidator implements ConstraintValidator<Region, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        HashSet<Object> regions = new HashSet<>();
        regions.add("China");
        regions.add("China-TaiWan");
        regions.add(("China-HongKong"));
        return regions.contains(s);
    }
}
