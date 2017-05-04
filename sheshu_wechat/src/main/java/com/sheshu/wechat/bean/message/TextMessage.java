package com.sheshu.wechat.bean.message;

/**
 * 董帮辉 2017-3-6.
 * 文本消息
 */
public class TextMessage extends BaseMessage {

    //回复消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
