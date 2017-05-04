package com.sheshu.wechat.mapper;

import com.sheshu.wechat.bean.page.PageAccessToken;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 董帮辉 on 2017-4-23.
 */
public interface PageAccessTokenMapper {

    //插入page_access_token
    int insert(PageAccessToken pageAccessToken);

    //获取page_access_token数据
    PageAccessToken findByOpenid(@Param("openid") String openid);

    //更新page_access_token
    int update(PageAccessToken pageAccessToken);
}
