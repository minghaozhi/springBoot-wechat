package com.sheshu.wechat.bean.user;

import java.util.List;

/**
 * 董帮辉 2017-4-19.
 */
public class UserListInfo {

    //关注该公众账号的总用户数
    private Integer total;

    //拉取的OPENID个数，最大值为10000
    private Integer count;

    //列表数据，OPENID的列表
    private Data data;

    //拉取列表的最后一个用户的OPENID
    private String next_openid;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }
}
