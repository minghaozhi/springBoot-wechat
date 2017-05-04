package com.sheshu.wechat.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sheshu.constant.WeChatConfigProperties;
import com.sheshu.utils.UrlRequestUtils;
import com.sheshu.wechat.bean.base.AccessToken;
import com.sheshu.wechat.bean.base.Ips;
import com.sheshu.wechat.bean.media.Material;
import com.sheshu.wechat.bean.page.JsApiTicket;
import com.sheshu.wechat.bean.page.PageAccessToken;
import com.sheshu.wechat.bean.page.PageUserInfo;
import com.sheshu.wechat.mapper.AccessTokenMapper;
import com.sheshu.wechat.mapper.PageAccessTokenMapper;
import com.sheshu.wechat.service.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Date;

/**
 * 董帮辉 2017-3-8.
 */
@Service("weChatService")
public class WeChatServiceImpl implements WeChatService{

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private WeChatConfigProperties weChatConfigProperties;

    @Autowired
    private AccessTokenMapper accessTokenMapper;

    @Autowired
    private PageAccessTokenMapper pageAccessTokenMapper;

    @Override
    public AccessToken getAccessToken() throws IOException {
        //从数据库获取access_token
        AccessToken accessToken = this.accessTokenMapper.find();
        if(!StringUtils.isEmpty(accessToken)){
            //获取当前时间
            Date date = new Date();
            //获取数据库中数据
            Date create_time = accessToken.getCreate_time();
            long difference = (date.getTime() - create_time.getTime())/1000;
            if(difference<7000){
                return accessToken;
            }else{
                //调用微信接口，获取access_token
                String accessTokenUrl = weChatConfigProperties.getAccessTokenUrl();
                String appId = weChatConfigProperties.getAppId();
                String appSecret = weChatConfigProperties.getAppSecret();
                String url = accessTokenUrl.replace("APPID",appId).replace("APPSECRET",appSecret);
                String result = UrlRequestUtils.sendGet(url);
                AccessToken token = null;
                if(!StringUtils.isEmpty(result)){
                    token = MAPPER.readValue(result, AccessToken.class);
                    //将accessToken存到数据库中
                    token.setCreate_time(new Date());
                    accessTokenMapper.update(token);
                }
                return token;
            }
        }else{
            //调用微信接口，获取access_token
            String accessTokenUrl = weChatConfigProperties.getAccessTokenUrl();
            String appId = weChatConfigProperties.getAppId();
            String appSecret = weChatConfigProperties.getAppSecret();
            String url = accessTokenUrl.replace("APPID",appId).replace("APPSECRET",appSecret);
            String result = UrlRequestUtils.sendGet(url);
            AccessToken token = null;
            if(!StringUtils.isEmpty(result)){
                token = MAPPER.readValue(result, AccessToken.class);
                //将accessToken存到数据库中
                token.setCreate_time(new Date());
                accessTokenMapper.insert(token);
            }
            return token;
        }
    }

    @Override
    public Ips getIpList() throws IOException {
        String serverIp = weChatConfigProperties.getServerIp();
        String access_token = this.getAccessToken().getAccess_token();
        String url = serverIp.replace("ACCESS_TOKEN", access_token);
        String result = UrlRequestUtils.sendPost(url, null);
        Ips ips = null;
        if(!StringUtils.isEmpty(result)){
            ips = MAPPER.readValue(result, Ips.class);
        }
        return ips;
    }

    @Override
    public Material uploadMaterial() throws IOException {

        String uploadURL = weChatConfigProperties.getUploadURL();

        AccessToken accessToken = this.getAccessToken();

        return null;
    }

    @Override
    public PageAccessToken getPageAccessToken(String code) throws IOException {
        String pageAccessTokenUrl = this.weChatConfigProperties.getPageAccessTokenUrl();
        String appId = weChatConfigProperties.getAppId();
        String appSecret = weChatConfigProperties.getAppSecret();
        pageAccessTokenUrl = pageAccessTokenUrl.replace("APPID",appId).replace("SECRET",appSecret).replace("CODE",code);
        String result = UrlRequestUtils.sendGet(pageAccessTokenUrl);
        PageAccessToken pageAccessToken = null;
        if(!StringUtils.isEmpty(result)){
            pageAccessToken = MAPPER.readValue(result,PageAccessToken.class);
            pageAccessToken.setCreate_time(new Date());
            pageAccessTokenMapper.insert(pageAccessToken);
        }
        return pageAccessToken;
    }

    @Override
    public PageUserInfo getUserInfo(PageAccessToken pageAccessToken) throws IOException {
        String userInfoUrl = weChatConfigProperties.getUserInfoUrl();
        userInfoUrl = userInfoUrl.replace("ACCESS_TOKEN",pageAccessToken.getAccess_token()).replace("OPENID",pageAccessToken.getOpenid());
        String result = UrlRequestUtils.sendGet(userInfoUrl);
        PageUserInfo pageUserInfo = null;
        if(!StringUtils.isEmpty(result)){
            pageUserInfo = MAPPER.readValue(result,PageUserInfo.class);
        }
        return pageUserInfo;
    }

    @Override
    public JsApiTicket getJsApiTiket() throws IOException {
        String jsapiTicketUrl = weChatConfigProperties.getJsapiTicketUrl();
        AccessToken accessToken = this.getAccessToken();
        jsapiTicketUrl = jsapiTicketUrl.replace("ACCESS_TOKEN",accessToken.getAccess_token());
        String result = UrlRequestUtils.sendGet(jsapiTicketUrl);
        JsApiTicket jsApiTicket = null;
        if(!StringUtils.isEmpty(result)){
            jsApiTicket = MAPPER.readValue(result,JsApiTicket.class);
        }
        return jsApiTicket;
    }

}
