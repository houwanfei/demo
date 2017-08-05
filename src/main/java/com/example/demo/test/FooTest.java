package com.example.demo.test;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houwanfei on 2017/7/20.
 */
@Component
@ConfigurationProperties(prefix="my")
public class FooTest {
    private List<String> servers = new ArrayList<String>();

    public List<String> getServers(){
        return this.servers;
    }
}
