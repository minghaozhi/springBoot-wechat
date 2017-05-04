package com.sheshu.wechat.service.impl;

import com.sheshu.utils.SecurityUtils;
import com.sheshu.wechat.bean.base.WeChat;
import com.sheshu.wechat.service.ValidateService;
import org.springframework.stereotype.Service;
import java.util.Arrays;

/**
 * 董帮辉 2017-3-5.
 */
@Service("validateService")
public class ValidateServiceImpl implements ValidateService{

    private static final String token = "sheshu";

    @Override
    public String checkSignature(WeChat weChat) {
        String signature = weChat.getSignature();
        String timestamp = weChat.getTimestamp();
        String nonce = weChat.getNonce();
        String echostr = weChat.getEchostr();
        //1）将token、timestamp、nonce三个参数进行字典序排序
        String[] strs = {token,timestamp,nonce};
        Arrays.sort(strs);
        //2）将三个参数字符串拼接成一个字符串进行sha1加密
        String str = strs[0] + strs[1] + strs[2];
        String digest = SecurityUtils.SHA1(str);
        //3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        if(digest.equals(signature)){
            return echostr;
        }else{
            return "error";
        }
    }
}
