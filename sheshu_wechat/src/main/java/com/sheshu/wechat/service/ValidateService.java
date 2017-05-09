package com.sheshu.wechat.service;

import com.sheshu.wechat.bean.base.WeChat;


public interface ValidateService {
    /**
     * 对微信信息进行校验
     * @param weChat
     * @return
     */
    String checkSignature(WeChat weChat);
}
