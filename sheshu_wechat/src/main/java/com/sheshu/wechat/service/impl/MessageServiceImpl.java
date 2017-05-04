package com.sheshu.wechat.service.impl;

import com.sheshu.constant.Constants;
import com.sheshu.utils.MessageUtils;
import com.sheshu.wechat.bean.message.News;
import com.sheshu.wechat.bean.message.NewsMessage;
import com.sheshu.wechat.bean.message.TextMessage;
import com.sheshu.wechat.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * 董帮辉 2017-3-6.
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Override
    public String responseMessage(Map<String, String> map) {
        String result = null;

        //开发者微信号
        String toUserName = map.get("ToUserName");
        //发送方帐号（一个OpenID）
        String fromUserName = map.get("FromUserName");
        //消息创建时间 （整型）
        String createTime = map.get("CreateTime");
        //消息类型
        String msgType = map.get("MsgType");
        //文本消息内容
        String content = map.get("Content");
        //消息id，64位整型
        String msgId = map.get("MsgId");

        //回复图文消息
        ArrayList<News> newsList = new ArrayList<News>();
        NewsMessage newsMessage = new NewsMessage();
        News news = new News();
        news.setTitle("董帮辉介绍");
        news.setDescription("");
        news.setPicUrl("http://15h35100r8.iask.in/pic/2.jpg");
        news.setUrl("https://mp.weixin.qq.com/s?__biz=MzI1NjYzMzMwMg==&tempkey=E1h5wEMDCojvpd%2BPpJmtGS09RbDYzSRbloMYvQOOattmkn8V%2F7IkyCALBnBv8U2u6BnoC2nsNIYRNqFwRpT35FtdY%2Bl3tki%2Fqaef5bEfDw5atp0ziv2J%2BaLzOk%2F%2F2Xev%2BH0hmfK%2FpSq06pez%2BPUFAw%3D%3D&chksm=6a22f1bb5d5578adc35244e4d29e8d560eb0fca2f8856d0dc469796e420499bc415c9f7c5970#rd");
        newsList.add(news);
        newsMessage.setToUserName(fromUserName);
        newsMessage.setFromUserName(toUserName);
        newsMessage.setCreateTime(new Date().getTime());
        newsMessage.setMsgType(Constants.MESSAGE_TYPE_NEWS);
        newsMessage.setArticles(newsList);
        newsMessage.setArticleCount(newsList.size());

        //回复图片消息
//        ImageMessage imageMessage = new ImageMessage();
//        Image image = new Image();
//        image.setMediaId("icnU9Ow2_5m7Fh-OYgE4-utN1jK9y7i1lfELZJzI_fOrKDTehlWVmkyddAFLdL_G");
//        imageMessage.setToUserName(fromUserName);
//        imageMessage.setFromUserName(toUserName);
//        imageMessage.setCreateTime(new Date().getTime());
//        imageMessage.setMsgType(Constants.MESSAGE_TYPE_IMAGE);
//        imageMessage.setImage(image);
//        String xml = MessageUtils.imageMessageToXml(imageMessage);

        //音乐消息
//        MusicMessage musicMessage = new MusicMessage();
//        Music music = new Music();
//        music.setThumbMediaId("13P0Aoo6yMLVRC_a_vBvXuRZc9LA4KShfEQp54SZl6lxqrdlYmLpZbNiJA_dTVGr");
//        music.setTitle("东京不太热");
//        music.setDescription("东京不太热");
//        music.setMusicUrl("http://15h35100r8.iask.in/music/1.mp3");
//        music.setHQMusicUrl("http://15h35100r8.iask.in/music/1.mp3");
//        musicMessage.setMusic(music);
//        musicMessage.setToUserName(fromUserName);
//        musicMessage.setFromUserName(toUserName);
//        musicMessage.setCreateTime(new Date().getTime());
//        musicMessage.setMsgType(Constants.MESSAGE_TYPE_MUSIC);
//        String xml = MessageUtils.musicMessageToXml(musicMessage);

        //回复文本消息
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setMsgType(Constants.MESSAGE_TYPE_TEXT);
        //判断接收的消息类型
        String xml = "";
        if(Constants.MESSAGE_TYPE_EVENT.equals(msgType)){//推送消息事件
            //事件类型
            String event = map.get("Event");
            if(event.equals(Constants.EVENT_TYPE_SUBSCRIBE)){
                textMessage.setContent("欢迎关注董帮辉的微信公众号！");
            }else if(Constants.EVENT_TYPE_CLICK.equals(event)){//点击事件
                textMessage.setContent("点击事件");
            }
            xml = MessageUtils.textMessageToXml(textMessage);
        }else if(Constants.MESSAGE_TYPE_LOCATION.equals(msgType)){//地理位置
            String label = map.get("Label");
            textMessage.setContent(label);
            xml = MessageUtils.textMessageToXml(textMessage);
        }

        xml = MessageUtils.newsMessageToXml(newsMessage);
        return xml;
    }
}
