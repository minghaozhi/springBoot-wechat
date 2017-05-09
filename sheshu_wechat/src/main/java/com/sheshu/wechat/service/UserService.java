package com.sheshu.wechat.service;

import com.sheshu.wechat.bean.user.UserInfo;
import com.sheshu.wechat.bean.user.UserListInfo;

import java.io.IOException;

public interface UserService {
    UserListInfo getUserListInfo() throws IOException;

    UserInfo getUserInfo(String openid) throws IOException;
}
