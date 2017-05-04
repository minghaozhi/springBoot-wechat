package com.sheshu.wechat.service;

import com.sheshu.wechat.bean.base.AccessToken;
import com.sheshu.wechat.bean.base.Ips;
import com.sheshu.wechat.bean.media.Material;
import com.sheshu.wechat.bean.page.JsApiTicket;
import com.sheshu.wechat.bean.page.PageAccessToken;
import com.sheshu.wechat.bean.page.PageUserInfo;

import java.io.IOException;

/**
 * 董帮辉 2017-3-8.
 */
public interface WeChatService {
    /**
     * 获取accessToken
     * @return
     * @throws IOException
     */
    AccessToken getAccessToken() throws IOException;

    /**
     * 获取ip列表
     * @return
     */
    Ips getIpList() throws IOException;


    /**
     * 上传图片
     * @return
     * @throws IOException
     */
    Material uploadMaterial() throws IOException;

    /**
     * 获取网页授权的access_token
     * @param code
     * @return
     */
    PageAccessToken getPageAccessToken(String code) throws IOException;

    /**
     * 获取用户基本信息
     * @param pageAccessToken
     * @return
     */
    PageUserInfo getUserInfo(PageAccessToken pageAccessToken) throws IOException;

    /**
     * 获取jsApiTicket
     * @return
     */
    JsApiTicket getJsApiTiket() throws IOException;
}
