package com.sheshu.wechat.controller;

import com.sheshu.utils.SecurityUtils;
import com.sheshu.utils.WeChatUtils;
import com.sheshu.wechat.bean.page.JsApiTicket;
import com.sheshu.wechat.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by 董帮辉 on 2017-4-22.
 */
@Controller
@RequestMapping("weChatView")
public class WeChatViewController {

    @Autowired
    private WeChatService weChatService;

    /**
     * 返回html模板.
     */
    @RequestMapping("/helloHtml")
    public String helloHtml(Model model, String code) throws IOException {

        //随机串
        String nonceStr = WeChatUtils.getNoncestr();
        //jsapi_ticket
        JsApiTicket jsApiTiket = weChatService.getJsApiTiket();
        //时间戳
        String timestamp = new Date().getTime()+"";
        //url
        String url = "http://15o70y7121.iok.la/weChatView/helloHtml";
        //对所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）
        String[] strs = {nonceStr,jsApiTiket.getTicket(),timestamp,url};
        Arrays.sort(strs);
        //进行sha1签名
        String str = strs[0] + strs[1] + strs[2] + strs[3];
        String signature = SecurityUtils.SHA1(str);

        model.addAttribute("nonceStr",nonceStr);
        model.addAttribute("signature",signature);
        return "/hello";
    }

}
