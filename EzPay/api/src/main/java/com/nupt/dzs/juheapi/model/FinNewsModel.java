package com.nupt.dzs.juheapi.model;

/**
 * Created by Administrator on 2016/5/18.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */

import java.util.List;
public class FinNewsModel {
    private String channelId;
    private String channelName;
    private String content;
    private String desc;
    private String html;
    private String link;
    private String nid;
    private List<ImageUrl> imageurls;
    private String pudDate;
    private int sentiment_display;
    private String source;
    private String title;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public List<ImageUrl> getImageurls() {
        return imageurls;
    }

    public void setImageurls(List<ImageUrl> imageurls) {
        this.imageurls = imageurls;
    }

    public String getPudDate() {
        return pudDate;
    }

    public void setPudDate(String pudDate) {
        this.pudDate = pudDate;
    }

    public int getSentiment_display() {
        return sentiment_display;
    }

    public void setSentiment_display(int sentiment_display) {
        this.sentiment_display = sentiment_display;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public class ImageUrl {
        private int height;
        private int width;
        private String url;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    @Override
    public String toString() {
        return "FinNewsModel{" +
                "channelId='" + channelId + '\'' +
                ", channelName='" + channelName + '\'' +
                ", content='" + content + '\'' +
                ", desc='" + desc + '\'' +
                ", html='" + html + '\'' +
                ", link='" + link + '\'' +
                ", nid='" + nid + '\'' +
                ", imageurls=" + imageurls +
                ", pudDate='" + pudDate + '\'' +
                ", sentiment_display=" + sentiment_display +
                ", source='" + source + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
