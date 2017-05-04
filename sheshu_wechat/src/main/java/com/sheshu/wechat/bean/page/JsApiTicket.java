package com.sheshu.wechat.bean.page;

/**
 * Created by 董帮辉 on 2017-4-23.
 */
public class JsApiTicket {

    //返回码
    private Integer errcode;

    //返回消息
    private String errmsg;

    //ticket
    private String ticket;

    //过期时间
    private Integer expires_in;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }
}
