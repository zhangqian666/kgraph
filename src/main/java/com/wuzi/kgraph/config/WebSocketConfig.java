package com.wuzi.kgraph.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Author 张迁-zhangqian
 * @Data 2019/9/26 8:13 PM
 * @Package com.wuzi.kgraph.config
 **/


@Configuration
public class WebSocketConfig {

    
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
