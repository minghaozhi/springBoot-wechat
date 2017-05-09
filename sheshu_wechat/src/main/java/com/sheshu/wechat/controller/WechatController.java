package com.sheshu.wechat.controller;

import com.sheshu.utils.DataShapeConvertUtils;
import com.sheshu.wechat.bean.base.WeChat;
import com.sheshu.wechat.bean.user.UserInfo;
import com.sheshu.wechat.bean.user.UserListInfo;
import com.sheshu.wechat.service.MessageService;
import com.sheshu.wechat.service.UserService;
import com.sheshu.wechat.service.ValidateService;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;


@RestController
@RequestMapping("/wechat")
public class WechatController {

    //注入微信校验的service
    @Autowired
    private ValidateService validateService;

    //微信消息回复service
    @Autowired

    private MessageService messageService;

    //用户管理
    @Autowired
    private UserService userService;

    /**
     * 校验微信服务器信息
     * @param weChat
     * @return
     */
    @RequestMapping(value = "/checkSignature",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    public String checkSignature(WeChat weChat){
        //对微信的信息进行校验
        String result = this.validateService.checkSignature(weChat);
        return result;
    }

    /**
     * 当普通微信用户向公众账号发消息时，微信服务器将POST消息的XML数据包到开发者填写的URL上。
     * @return
     */
    @RequestMapping(value = "/checkSignature",method = RequestMethod.POST, produces = "application/xml;charset=UTF-8")
    public String responseMessage(HttpServletRequest request) throws IOException, DocumentException {
        Map<String, String> map = DataShapeConvertUtils.parseXml(request);
        String result = this.messageService.responseMessage(map);
        return result;
    }

    /**
     * 获取关注的用户信息列表
     * @return
     */
    @RequestMapping(value = "getUserList", method = RequestMethod.GET)
    public UserListInfo getUserList() throws IOException {
        UserListInfo userListInfo =  this.userService.getUserListInfo();
        return userListInfo;
    }

    /**
     * 获取用户信息
     * @return
     */
    @RequestMapping(value = "getUserInfo",method = RequestMethod.GET)
    public UserInfo getUserInfo(@RequestParam("openid")String openid) throws IOException {
        UserInfo userInfo = this.userService.getUserInfo(openid);
        return userInfo;
    }

}
