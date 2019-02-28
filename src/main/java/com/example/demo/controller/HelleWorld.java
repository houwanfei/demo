package com.example.demo.controller;

import com.example.demo.annotation.MethodLog;
import com.example.demo.component.Sender;
import com.example.demo.entity.FilmTag;
import com.example.demo.mappers.FilmTagMapper;
import com.example.demo.test.FooTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by houwanfei on 2017/6/18.
 */
@Controller
@EnableAutoConfiguration
public class HelleWorld {
    //@Value("${foo.list.name}")
    //private String name;
    @Value("${number}")
    private  int number;
    @Autowired
    private FooTest test;
    @Autowired
    private FilmTagMapper filmTagMapper;
    @Autowired
    private Sender sender;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(){
        //return "Hello world!"+test.getServers().get(0);
        FilmTag filmTag = filmTagMapper.getOne(2);
        System.out.println(filmTag.getTagUrl());
        sender.send("First Msg");
        return "index";
    }

    @MethodLog(description = "hello world")
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}
