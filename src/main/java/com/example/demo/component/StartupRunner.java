package com.example.demo.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by houwanfei on 2017/7/13.
 */
@Component
public class StartupRunner implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception{
        System.out.println("<<<<<<<<<<<<这个是测试CommandLineRunn接口>>>>>>>>>>>>>>");
    }
}
