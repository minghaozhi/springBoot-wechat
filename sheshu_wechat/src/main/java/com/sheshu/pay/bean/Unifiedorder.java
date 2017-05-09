package com.sheshu.pay.bean;

/**
 * 统一下单Bean
 */
public class Unifiedorder extends BaseUnifiedorder{

    //通知地址
    private String notify_url;

    //交易类型
    private String trade_type;

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }
}
