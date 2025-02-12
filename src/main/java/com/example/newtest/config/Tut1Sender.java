package com.example.newtest.config;

import jakarta.annotation.Resource;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Author: 93285
 * @Date: 2024/3/1
 * @Description: sender
 * @PROJECT_NAME: cliche
 * @Package_name: IntelliJ IDEA
 **/
// Sender



public class Tut1Sender {

    @Resource
    private RabbitTemplate template;

    @Resource
    private Queue queue;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Hello World!";
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}