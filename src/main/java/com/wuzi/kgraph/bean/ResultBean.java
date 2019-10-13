package com.wuzi.kgraph.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author 张迁-zhangqian
 * @Data 2019/10/1 10:34 PM
 * @Package com.wuzi.kgraph.bean
 **/


@Getter
@Setter
public class ResultBean<T> {
    private int code;
    private String message;
    private T data;
}
