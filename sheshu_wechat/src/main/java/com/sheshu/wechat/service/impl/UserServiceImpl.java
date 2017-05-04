package com.sheshu.wechat.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sheshu.constant.WeChatConfigProperties;
import com.sheshu.utils.UrlRequestUtils;
import com.sheshu.wechat.bean.base.AccessToken;
import com.sheshu.wechat.bean.user.UserInfo;
import com.sheshu.wechat.bean.user.UserListInfo;
import com.sheshu.wechat.service.UserService;
import com.sheshu.wechat.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * 董帮辉 2017-4-19.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private WeChatService weChatService;

    @Autowired
    private WeChatConfigProperties weChatConfigProperties;

    @Override
    public UserListInfo getUserListInfo() throws IOException {
        AccessToken accessToken = weChatService.getAccessToken();
        String userGet = weChatConfigProperties.getUserGet();
        userGet = userGet.replace("ACCESS_TOKEN", accessToken.getAccess_token()).replace("NEXT_OPENID","");
        String result = UrlRequestUtils.sendGet(userGet);
        UserListInfo userListInfo = null;
        if(!StringUtils.isEmpty(result)){
            userListInfo = MAPPER.readValue(result, UserListInfo.class);
        }
        return userListInfo;
    }

    @Override
    public UserInfo getUserInfo(String openid) throws IOException {
        AccessToken accessToken = weChatService.getAccessToken();
        String userInfo = weChatConfigProperties.getUserInfoUrl();
        userInfo = userInfo.replace("ACCESS_TOKEN",accessToken.getAccess_token()).replace("OPENID",openid);
        String result = UrlRequestUtils.sendGet(userInfo);
        UserInfo userInfoA = null;
        if(!StringUtils.isEmpty(result)){
            userInfoA = MAPPER.readValue(result, UserInfo.class);
        }
        return userInfoA;
    }
}
