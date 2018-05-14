package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @auther houwanfei
 * @create 2018-01-18 下午2:13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface HBean {
    String value();
}
