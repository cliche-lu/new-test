package com.example.newtest.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.example.newtest.component.MyComponent.FANOUT_QUEUE1;

/**
 * 接收消息
 *
 * @Author: 93285
 * @Date: 2024/3/1
 * @Description: RabbitMQReciver
 * @PROJECT_NAME: cliche
 * @Package_name: IntelliJ IDEA
 **/
//@Component
class RabbitMQReciver {

    @RabbitListener(queues = FANOUT_QUEUE1)
    public void reciveLogAll(String msg) throws Exception {
        System.out.println("log.all:" + msg);
    }
}