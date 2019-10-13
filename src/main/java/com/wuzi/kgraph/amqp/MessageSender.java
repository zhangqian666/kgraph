package com.wuzi.kgraph.amqp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @Author 张迁-zhangqian
 * @Data 2019/9/27 5:00 PM
 * @Package com.wuzi.kgraph.amqp
 **/

@Slf4j
@Component
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void directSend(String routingKey, String message) {
        log.info(String.format("directSend: from : %s to : %s", routingKey, message));
        //参数一：交换器名称，可以省略（省略存储到AMQP default交换器）；参数二：路由键名称（direct模式下路由键=队列名称）；参数三：存储消息
        try {
            this.rabbitTemplate.convertAndSend(DirectConfig.DIRECT_EXCHANGE, routingKey, message.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
