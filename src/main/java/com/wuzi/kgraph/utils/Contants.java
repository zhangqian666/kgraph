package com.wuzi.kgraph.utils;

import com.wuzi.kgraph.websocket.WsServer;

import javax.websocket.Session;
import java.util.HashMap;

/**
 * @Author 张迁-zhangqian
 * @Data 2019/10/1 9:31 PM
 * @Package com.wuzi.kgraph.websocket
 **/


public class Contants {
    public static HashMap<WsServer, Session> sWebSocketServers = new HashMap<>();
    public static HashMap<String,WsServer> sWebSocketUserNames = new HashMap<>();
}
