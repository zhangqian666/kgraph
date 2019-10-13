package com.wuzi.kgraph.websocket;

import javax.websocket.Session;
import java.io.IOException;

/**
 * @Author 张迁-zhangqian
 * @Data 2019/9/27 1:43 PM
 * @Package com.wuzi.kgraph.websocket
 **/


public class WsMessageUtil {

    public static boolean sendMessage(Session session, String content) {
        if (session == null) return false;
        try {
            session.getBasicRemote().sendText(content);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean sendMessage(Session session, long userId) {


        return false;
    }
}
