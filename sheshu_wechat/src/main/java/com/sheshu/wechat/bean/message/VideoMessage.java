package com.sheshu.wechat.bean.message;

/**
 * 视频消息
 */
public class VideoMessage extends BaseMessage {

    private Video Video;

    public com.sheshu.wechat.bean.message.Video getVideo() {
        return Video;
    }

    public void setVideo(com.sheshu.wechat.bean.message.Video video) {
        Video = video;
    }
}
