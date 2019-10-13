package com.wuzi.kgraph.controller;

import com.wuzi.kgraph.amqp.DirectConfig;
import com.wuzi.kgraph.amqp.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 张迁-zhangqian
 * @Data 2019/9/27 10:08 AM
 * @Package com.wuzi.kgraph.websocket
 **/


@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    MessageSender messageSender;

    @PostMapping("/test")
    public String test(String message) {

        messageSender.directSend(DirectConfig.DIRECT_ROUTING_KEY1, message);

        return "测试成功,已经拿到数据了: " + message;
    }
}
