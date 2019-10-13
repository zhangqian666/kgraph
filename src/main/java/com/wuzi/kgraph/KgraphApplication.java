package com.wuzi.kgraph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableWebSocket
public class KgraphApplication {

    public static void main(String[] args) {
        SpringApplication.run(KgraphApplication.class, args);
    }

}
