package com.sheshu.wechat.mapper;

import com.sheshu.wechat.bean.page.PageAccessToken;
import org.apache.ibatis.annotations.Param;


public interface PageAccessTokenMapper {

    //插入page_access_token
    int insert(PageAccessToken pageAccessToken);

    //获取page_access_token数据
    PageAccessToken findByOpenid(@Param("openid") String openid);

    //更新page_access_token
    int update(PageAccessToken pageAccessToken);
}
