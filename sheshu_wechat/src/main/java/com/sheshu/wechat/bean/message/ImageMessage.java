package com.sheshu.wechat.bean.message;

/**
 * 董帮辉 2017-3-10.
 * 图片消息
 */
public class ImageMessage extends BaseMessage {

    private Image Image;

    public com.sheshu.wechat.bean.message.Image getImage() {
        return Image;
    }

    public void setImage(com.sheshu.wechat.bean.message.Image image) {
        Image = image;
    }
}
