package com.wuzi.kgraph.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 张迁-zhangqian
 * @Data 2019/9/27 4:57 PM
 * @Package com.wuzi.kgraph.amqp
 **/


@Configuration
public class DirectConfig {
    //redirect模式
    public static final String DIRECT_QUEUE1 = "direct.queue1";
    public static final String DIRECT_EXCHANGE = "direct.exchange";
    public static final String DIRECT_QUEUE2 = "direct.queue2";

    public static final String DIRECT_ROUTING_KEY1 = "direct.pwl1";
    public static final String DIRECT_ROUTING_KEY2 = "direct.pwl2";

    /**
     * direct模式
     * 消息中的路由键（routing key）如果和 Binding 中的 binding key 一致， 交换器就将消息发到对应的队列中。路由键与队列名完全匹配
     *
     * @return
     */
    @Bean
    public Queue directQueue1() {
        return new Queue(DIRECT_QUEUE1);
    }

    @Bean
    Queue directQueue2() {
        return new Queue(DIRECT_QUEUE2);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    public Binding directBinding1() {
        return BindingBuilder.bind(directQueue1()).to(directExchange()).with(DIRECT_ROUTING_KEY1);
    }

    @Bean
    public Binding directBinding2() {
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with(DIRECT_ROUTING_KEY2);
    }
}
