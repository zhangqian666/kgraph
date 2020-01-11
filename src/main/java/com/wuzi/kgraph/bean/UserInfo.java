package com.wuzi.kgraph.bean;

import com.wuzi.kgraph.websocket.WsServer;
import lombok.Getter;
import lombok.Setter;

import javax.websocket.Session;

/**
 * @Author 张迁-zhangqian
 * @Data 2019/10/31 2:05 PM
 * @Package com.wuzi.kgraph.bean
 **/


@Getter
@Setter
public class UserInfo {
    String name;
    String wx_openid;
    WsServer wsServer;
    Session wsSession;
    String openid;

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", wx_openid='" + wx_openid + '\'' +
                ", wsServer=" + wsServer +
                ", wsSession=" + wsSession +
                ", openid='" + openid + '\'' +
                '}';
    }
}
