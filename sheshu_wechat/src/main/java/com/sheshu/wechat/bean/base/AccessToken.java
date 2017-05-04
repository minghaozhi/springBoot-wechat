package com.sheshu.wechat.bean.base;

import java.util.Date;

/**
 * 董帮辉 2017-3-8
 */
public class AccessToken {

    private String access_token;

    private Integer expires_in;

    private Date create_time;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
