package com.example.demo.component;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * Created by houwanfei on 2017/7/13.
 */
@Component
public class TestPreDestroy {
    @PreDestroy
    public void destroy(){
        System.out.println("<<<<<<<<<<<<这个是测试PreDestroy注解>>>>>>>>>>>>>>");
    }
}
