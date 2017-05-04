package com.sheshu.utils;

import com.sheshu.pay.bean.Unifiedorder;
import com.sheshu.wechat.bean.message.*;
import com.thoughtworks.xstream.XStream;

/**
 * 董帮辉 2017-3-6.
 * 微信消息处理类
 */
public class MessageUtils {

    /**
     * 文本消息转换为xml
     * @return
     */
    public static String textMessageToXml(TextMessage textMessage){
        XStream xStream = new XStream();
        xStream.alias("xml", textMessage.getClass());
        String xml = xStream.toXML(textMessage);
        return xml;
    }

    /**
     * 图片消息转换为xml
     * @param imageMessage
     * @return
     */
    public static String imageMessageToXml(ImageMessage imageMessage){
        XStream xStream = new XStream();
        xStream.alias("xml", imageMessage.getClass());
        String xml = xStream.toXML(imageMessage);
        return xml;
    }

    /**
     * 音频消息转为xml
     * @param voiceMessage
     * @return
     */
    public static String voiceMessageToXml(VoiceMessage voiceMessage){
        XStream xStream = new XStream();
        xStream.alias("xml", voiceMessage.getClass());
        String xml = xStream.toXML(voiceMessage);
        return xml;
    }

    /**
     * 视频消息转为xml
     * @param videoMessage
     * @return
     */
    public static String videoMessageToXml(VideoMessage videoMessage){
        XStream xStream = new XStream();
        xStream.alias("xml", videoMessage.getClass());
        String xml = xStream.toXML(videoMessage);
        return xml;
    }

    /**
     * 图文消息转为xml
     * @param newsMessage
     * @return
     */
    public static String newsMessageToXml(NewsMessage newsMessage){
        XStream xStream = new XStream();
        xStream.alias("xml", newsMessage.getClass());
        xStream.alias("item", new News().getClass());
        String xml = xStream.toXML(newsMessage);
        return xml;
    }

    /**
     * 音乐消息转为xml
     * @param musicMessage
     * @return
     */
    public static String musicMessageToXml(MusicMessage musicMessage){
        XStream xStream = new XStream();
        xStream.alias("xml", musicMessage.getClass());
        String xml = xStream.toXML(musicMessage);
        return xml;
    }

    /**
     * 统一下单对象转为xml
     * @param unifiedorder
     * @return
     */
    public static String unifiedorderToXml(Unifiedorder unifiedorder){
        XStream xStream = new XStream();
        xStream.alias("xml",unifiedorder.getClass());
        String xml = xStream.toXML(unifiedorder);
        return xml;
    }

}
