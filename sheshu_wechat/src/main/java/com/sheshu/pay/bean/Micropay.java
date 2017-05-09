package com.sheshu.pay.bean;

/**
 * 提交刷卡支付Bean
 */
public class Micropay extends BaseUnifiedorder{

    //授权码
    private String auth_code;

    public String getAuth_code() {
        return auth_code;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }
}
