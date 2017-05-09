package com.sheshu.wechat.service;

import java.util.Map;


public interface MessageService {
    /**
     * 微信回复的方法
     * @param map
     * @return
     */
    String responseMessage(Map<String, String> map);
}
