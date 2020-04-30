package com.soft1851.springboot.aop.annotation;

import java.lang.annotation.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/14
 * @Version 1.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ImageHandle {

    /**
     * 对图片进行操作的名称
     *
     * @return
     */
    String[] operations() default "";
}
