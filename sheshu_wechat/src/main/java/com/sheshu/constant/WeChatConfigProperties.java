package com.sheshu.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 董帮辉 2017-3-8.
 */
@Component
@ConfigurationProperties(prefix = "wechat")
public class WeChatConfigProperties {

    private String appId;

    private String appSecret;

    private String mchId;

    private String accessTokenUrl;

    private String uploadURL;

    private String createMenuUrl;

    private String queryMenuUrl;

    private String deleteMenuUrl;

    private String serverIp;

    private String serverUrl;

    private String clickToUrl;

    private String pageAccessTokenUrl;

    private String userGet;

    private String userInfoUrl;

    private String jsapiTicketUrl;

    private String micropay;

    private String orderquery;

    private String reverse;

    private String unifiedorder;

    private String refund;

    private String refundquery;

    private String downloadbill;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getAccessTokenUrl() {
        return accessTokenUrl;
    }

    public void setAccessTokenUrl(String accessTokenUrl) {
        this.accessTokenUrl = accessTokenUrl;
    }

    public String getUploadURL() {
        return uploadURL;
    }

    public void setUploadURL(String uploadURL) {
        this.uploadURL = uploadURL;
    }

    public String getCreateMenuUrl() {
        return createMenuUrl;
    }

    public void setCreateMenuUrl(String createMenuUrl) {
        this.createMenuUrl = createMenuUrl;
    }

    public String getQueryMenuUrl() {
        return queryMenuUrl;
    }

    public void setQueryMenuUrl(String queryMenuUrl) {
        this.queryMenuUrl = queryMenuUrl;
    }

    public String getDeleteMenuUrl() {
        return deleteMenuUrl;
    }

    public void setDeleteMenuUrl(String deleteMenuUrl) {
        this.deleteMenuUrl = deleteMenuUrl;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getClickToUrl() {
        return clickToUrl;
    }

    public void setClickToUrl(String clickToUrl) {
        this.clickToUrl = clickToUrl;
    }

    public String getUserGet() {
        return userGet;
    }

    public void setUserGet(String userGet) {
        this.userGet = userGet;
    }

    public String getUserInfoUrl() {
        return userInfoUrl;
    }

    public void setUserInfoUrl(String userInfoUrl) {
        this.userInfoUrl = userInfoUrl;
    }

    public String getPageAccessTokenUrl() {
        return pageAccessTokenUrl;
    }

    public void setPageAccessTokenUrl(String pageAccessTokenUrl) {
        this.pageAccessTokenUrl = pageAccessTokenUrl;
    }

    public String getJsapiTicketUrl() {
        return jsapiTicketUrl;
    }

    public void setJsapiTicketUrl(String jsapiTicketUrl) {
        this.jsapiTicketUrl = jsapiTicketUrl;
    }

    public String getMicropay() {
        return micropay;
    }

    public void setMicropay(String micropay) {
        this.micropay = micropay;
    }

    public String getOrderquery() {
        return orderquery;
    }

    public void setOrderquery(String orderquery) {
        this.orderquery = orderquery;
    }

    public String getReverse() {
        return reverse;
    }

    public void setReverse(String reverse) {
        this.reverse = reverse;
    }

    public String getUnifiedorder() {
        return unifiedorder;
    }

    public void setUnifiedorder(String unifiedorder) {
        this.unifiedorder = unifiedorder;
    }

    public String getRefund() {
        return refund;
    }

    public void setRefund(String refund) {
        this.refund = refund;
    }

    public String getRefundquery() {
        return refundquery;
    }

    public void setRefundquery(String refundquery) {
        this.refundquery = refundquery;
    }

    public String getDownloadbill() {
        return downloadbill;
    }

    public void setDownloadbill(String downloadbill) {
        this.downloadbill = downloadbill;
    }
}
