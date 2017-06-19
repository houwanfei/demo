package com.example.demo.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by houwanfei on 2017/6/18.
 */
@RestController
@EnableAutoConfiguration
public class HelleWorld {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(){
        return "Hello world!";
    }
}
