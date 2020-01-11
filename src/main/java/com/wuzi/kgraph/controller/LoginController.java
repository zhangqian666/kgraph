package com.wuzi.kgraph.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 张迁-zhangqian
 * @Data 2019/10/31 2:00 PM
 * @Package com.wuzi.kgraph.controller
 **/


@RestController
@RequestMapping("/login")
public class LoginController {


    @PostMapping("/WX")
    public void wxLogin() {

    }
}
