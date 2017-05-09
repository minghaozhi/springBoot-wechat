package com.sheshu.pay.service.impl;

import com.sheshu.constant.WeChatConfigProperties;
import com.sheshu.pay.bean.Unifiedorder;
import com.sheshu.pay.service.ScanQRService;
import com.sheshu.utils.WeChatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service("scanQRService")
public class ScanQRServiceImpl implements ScanQRService {

    @Autowired
    private WeChatConfigProperties weChatConfigProperties;


    @Override
    public String unifiedorder() {

        String unifiedorder = weChatConfigProperties.getUnifiedorder();

        Map<String, Object> params = new HashMap<>();
        params.put("appid",weChatConfigProperties.getAppId());
        params.put("body","暖气费");
        params.put("mch_id",weChatConfigProperties.getMchId());
        params.put("nonce_str",WeChatUtils.getNoncestr());
        params.put("notify_url","");

        Unifiedorder uni = new Unifiedorder();
        uni.setAppid(weChatConfigProperties.getAppId());
        uni.setMch_id(weChatConfigProperties.getMchId());
        uni.setNonce_str(WeChatUtils.getNoncestr());

        return null;
    }
}
