package com.example.newtest.config;

/**
 * @Author: 93285
 * @Date: 2024/3/1
 * @Description: Tut1Receiver
 * @PROJECT_NAME: cliche
 * @Package_name: IntelliJ IDEA
 **/

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "hello")
public class Tut1Receiver {

    @RabbitHandler
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "'");
    }
}