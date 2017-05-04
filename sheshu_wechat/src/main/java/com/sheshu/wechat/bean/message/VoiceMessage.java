package com.sheshu.wechat.bean.message;

/**
 * 董帮辉 2017-3-10.
 * 语音消息
 */
public class VoiceMessage extends BaseMessage {

    private Voice Voice;

    public com.sheshu.wechat.bean.message.Voice getVoice() {
        return Voice;
    }

    public void setVoice(com.sheshu.wechat.bean.message.Voice voice) {
        Voice = voice;
    }
}
