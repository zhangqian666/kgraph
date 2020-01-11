package com.wuzi.kgraph.utils;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.client.RestTemplate;

/**
 * @Author 张迁-zhangqian
 * @Data 2020/1/11 7:06 PM
 * @Package com.wuzi.kgraph.utils
 **/


public class WeChatUtils {
    //获取微信用户信息api链接
    private static String url = "https://api.weixin.qq.com/sns/jscode2session?" +
            "appid=wxfd7f2aa01d7a50ce" +
            "&secret=36be6c3b73334ebbf86061578bd731fb" +
            "&grant_type=authorization_code" +
            "&js_code=";
    private static RestTemplate restTemplate = new RestTemplate();


    //获取微信用户数据
    public static String getData(String code){
        String data = restTemplate.getForObject(url + code, String.class);
        JSONObject jsonObject = null;
        //转换为json格式提取openid并传回，若转换失败传回null，若数据获取失败传回error
        try {
            jsonObject = new JSONObject(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if( jsonObject == null ){
            return "null";
        } else if( jsonObject.has("openid") ) {
            try {
                return jsonObject.getString("openid");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return "error";
    }
}
