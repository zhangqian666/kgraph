package com.wuzi.kgraph.websocket;

import com.google.gson.Gson;
import com.wuzi.kgraph.amqp.DirectConfig;
import com.wuzi.kgraph.amqp.MessageSender;
import com.wuzi.kgraph.bean.RbUserBean;
import com.wuzi.kgraph.bean.ResultBean;
import com.wuzi.kgraph.bean.UserInfo;
import com.wuzi.kgraph.utils.Contants;
import com.wuzi.kgraph.utils.WeChatUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import static com.wuzi.kgraph.utils.Contants.idWithUserMap;

/**
 * @Author 张迁-zhangqian
 * @Data 2019/9/27 10:03 AM
 * @Package com.wuzi.kgraph.websocket
 **/


@Slf4j
@Component
@ServerEndpoint("/question/{openid}")
public class WsServer {

    //  这里使用静态，让 service 属于类
    private static MessageSender messageSender;

    // 注入的时候，给类的 service 注入
    @Autowired
    public void setChatService(MessageSender messageSender) {
        WsServer.messageSender = messageSender;
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("openid") String openid) {
        UserInfo userInfo = new UserInfo();
        userInfo.setWsServer(this);
        userInfo.setWsSession(session);
        String wxopenid = WeChatUtils.getData(openid);
        userInfo.setWx_openid(wxopenid);
        Contants.idWithUserMap.put(session.getId(), userInfo);
        log.info("有人链接上---" + idWithUserMap.size());


        log.info("userinfo  : " + userInfo.toString());
        ResultBean<String> stringResultBean = new ResultBean<>();
        stringResultBean.setCode(200);
        stringResultBean.setData("你已经链接上我了小兄弟，:" + userInfo.getName());
        WsMessageUtil.sendMessage(session, new Gson().toJson(stringResultBean));
    }


    @OnMessage
    public void onMessage(Session session, String message) {
        log.info("我收到了消息" + message);

        ResultBean<String> stringResultBean = new ResultBean<>();
        stringResultBean.setCode(200);
        stringResultBean.setData("我收到了你的消息：" + message);

        WsMessageUtil.sendMessage(session, new Gson().toJson(stringResultBean));

        RbUserBean rbUserBean = new RbUserBean();
        rbUserBean.setQaId(session.getId());
        rbUserBean.setQuestion(message);
        Gson gson = new Gson();
        String questionStr = gson.toJson(rbUserBean);

        messageSender.directSend(DirectConfig.DIRECT_ROUTING_KEY1, questionStr);
    }

    @OnClose
    public void onClose(Session session) {
        log.error(String.format("有人断开连接----名字叫：%s", session.getId()));
        idWithUserMap.remove(session.getId());
        log.error(String.format("有人断开连接----当前剩余链接数量：%s", idWithUserMap.size()));
    }

    @OnError
    public void onError(Throwable error) {
        log.error("发生了错误：" + error.toString());
    }

}
