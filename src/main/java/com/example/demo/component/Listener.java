package com.example.demo.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;


/**
 * Created by houwanfei on 2017/7/27.
 */
@Configuration
@RabbitListener(queues = "foo")
public class Listener {

    private static final Logger logger = LoggerFactory.getLogger(Listener.class);

    @Bean
    public Queue fooQueue(){
        return new Queue("foo");
    }

    @RabbitHandler
    public void process(@Payload String foo){
        logger.info("Listener:"+foo);
    }
}
