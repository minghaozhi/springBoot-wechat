package com.sheshu.wechat.mapper;

import com.sheshu.wechat.bean.base.AccessToken;


public interface AccessTokenMapper {

    //插入access_token
    int insert(AccessToken accessToken);

    //获取access_token数据
    AccessToken find();

    //更新access_token
    int update(AccessToken accessToken);
}