package com.sheshu.wechat.mapper;

import com.sheshu.wechat.bean.base.AccessToken;

/**
 * Created by 董帮辉 on 2017-4-22.
 */
public interface AccessTokenMapper {

    //插入access_token
    int insert(AccessToken accessToken);

    //获取access_token数据
    AccessToken find();

    //更新access_token
    int update(AccessToken accessToken);
}