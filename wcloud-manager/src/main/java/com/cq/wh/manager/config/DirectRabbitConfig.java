package com.cq.wh.manager.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author : WangHao
 * @Date: 2020-04-12 09:48
 * @Description : 直连交换机配置类  直连型交换机，根据消息携带的路由键将消息投递给对应队列。
 * 大致流程，有一个队列绑定到一个直连交换机上，同时赋予一个路由键 routing key 。
 * 然后当一个消息携带着路由值为X，这个消息通过生产者发送给交换机时，交换机就会根据这个路由值X去寻找绑定值也是X的队列。
 */
@Configuration
public class DirectRabbitConfig {


    //队列 起名：TestDirectQueue
    @Bean
    public Queue TestDirectQueue(){
        return new Queue("TestDirectQueue",true);   //true 是否持久
    }

    //Direct交换机 起名：TestDirectExchange
    @Bean
    public DirectExchange TestDirectExchange(){
        return new DirectExchange("TestDirectExchange");
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
    @Bean
    public Binding bindingDirect(){
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("TestDirectRouting");
    }
}
