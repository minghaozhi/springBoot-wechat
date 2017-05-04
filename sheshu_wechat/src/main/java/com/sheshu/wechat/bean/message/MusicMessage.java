package com.sheshu.wechat.bean.message;

/**
 * 董帮辉 2017-3-10
 * 音乐消息
 */
public class MusicMessage extends BaseMessage {

    private Music Music;

    public com.sheshu.wechat.bean.message.Music getMusic() {
        return Music;
    }

    public void setMusic(com.sheshu.wechat.bean.message.Music music) {
        Music = music;
    }
}
