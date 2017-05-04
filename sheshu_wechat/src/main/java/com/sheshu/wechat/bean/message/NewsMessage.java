package com.sheshu.wechat.bean.message;

import java.util.List;

/**
 * 董帮辉 2017-3-6.
 * 图文消息
 */
public class NewsMessage extends BaseMessage {

    //图文消息个数
    private int ArticleCount;

    //多条图文消息信息
    private List<News> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<News> getArticles() {
        return Articles;
    }

    public void setArticles(List<News> articles) {
        Articles = articles;
    }
}
