package com.wuzi.kgraph.amqp;

import com.google.gson.Gson;
import com.wuzi.kgraph.bean.RbUserBean;
import com.wuzi.kgraph.utils.Contants;
import com.wuzi.kgraph.websocket.WsMessageUtil;
import com.wuzi.kgraph.websocket.WsServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.io.UnsupportedEncodingException;

/**
 * @Author 张迁-zhangqian
 * @Data 2019/9/27 5:03 PM
 * @Package com.wuzi.kgraph.amqp
 **/


@Slf4j
@Component
public class MessageReceiver {
    @RabbitListener(queues = DirectConfig.DIRECT_QUEUE2)
    public void process2(Message message) {
        String messageBody = null;
        try {
            messageBody = new String(message.getBody(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        log.info(String.format("DIRECT_QUEUE2收到消息：%s", messageBody));
        Gson gson = new Gson();
        if (!messageBody.isEmpty()) {
            RbUserBean rbUserBean = gson.fromJson(messageBody, RbUserBean.class);
            Session session = null;
            try {
                session = Contants.sWebSocketServers.get(Contants.sWebSocketUserNames.get(rbUserBean.getUserName()));
                WsMessageUtil.sendMessage(
                        session, messageBody);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }


        }
    }

}
