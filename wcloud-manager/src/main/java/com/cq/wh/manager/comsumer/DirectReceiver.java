package com.cq.wh.manager.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author : WangHao
 * @Date: 2020-04-12 10:19
 * @Description : 直连类型消费者
 */

@Component
@RabbitListener(queues = "TestDirectQueue") //监听的队列名称 TestDirectQueue
public class DirectReceiver {

    @RabbitHandler
    public void process(Map testMessage){
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
    }
}
