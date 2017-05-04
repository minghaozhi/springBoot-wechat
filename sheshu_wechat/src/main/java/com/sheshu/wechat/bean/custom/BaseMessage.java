package com.sheshu.wechat.bean.custom;

/**
 * 董帮辉 2017-3-27.
 * 客服消息基类
 */
public class BaseMessage {

    //普通用户openid
    private String touser;

    //消息类型
    private String msgtype;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
}
