package com.wuzi.kgraph.utils;


import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

/**
 * @Author 张迁-zhangqian
 * @Data 2020/1/11 7:06 PM
 * @Package com.wuzi.kgraph.utils
 **/


public class WeChatUtils {
    //获取微信用户信息api链接

    private static String appId = "wxfd7f2aa01d7a50ce";
    private static String appsecret = "0fa3e6d36305f90f9e9ee27e1a073f73";


    //获取微信用户数据
    public static String getData(String code) {
        //向微信服务器 使用登录凭证 code 获取 session_key 和 openid
        // 请求参数
        String params = "appid=" + appId + "&secret=" + appsecret + "&js_code=" + code + "&grant_type=authorization_code";

        // 发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);

        JSONObject jsonObject = JSONObject.parseObject(sr);

        return (String) jsonObject.get("openid");

    }
}
