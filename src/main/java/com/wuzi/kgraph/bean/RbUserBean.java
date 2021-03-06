package com.wuzi.kgraph.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author 张迁-zhangqian
 * @Data 2019/10/1 9:41 PM
 * @Package com.wuzi.kgraph.bean
 **/

@Setter
@Getter
public class RbUserBean {
    private String qaId;
    private String question;
    private String answer;

    @Override
    public String toString() {
        return "RbUserBean{" +
                "qaId='" + qaId + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
