package com.example.tongpao.bean;

import java.util.List;

public class SingleBean {
    /**
     * statusCode : 100
     * message : 请求成功！
     * serverTime : 2020-08-19 15:27:15
     */

    private StatusBean status;
    /**
     * articleId : 183
     * userId : 100001
     * nickName : 官方小袍
     * title : 古人相见时的礼仪：揖礼、叉手礼、抱拳礼，不同时代礼仪文化不同
     * cover : https://tpcdn.whfpsoft.com:443/File/article/20181122/67642eb8b6e01c3f3bbe13473753840b.jpg
     * contentDescribe : 上一篇中我们讲到揖礼，揖礼盛行于周、汉、三国、两晋、南北朝期间。 那到了汉代以后，渐有高座，凳椅先后问世，人们不再"席地而坐"，使原来生活中的"跪坐"起了很大变化，但跪拜礼仍然存在，却变成了等级差别的标志，主要广泛运用于官场之中。 唐、宋、金辽、金、元时期的一种行礼方式是叉手礼，又名交手礼。而唐宋两代的叉手礼又有些不同。 唐代叉手礼的行法是两手交于胸前，左手握住右手，右手拇指上翘。(图为安阳唐代赵逸公墓中出土的壁画)。 女子叉手礼(万福礼)用于日常见面，辞别时，身体肃立，两手相扣，右手在上，放于左腰侧，微俯身约20度，微动手，微屈膝。或者左腿前置，右腿后置，两腿相交 ;右手朝上，左手朝下，并拢
     * createTime : 2018-11-22 11:21
     * type : 0
     * shortUrl :
     * browseNumber : 0
     * htmlLocalUrl :
     * content :
     */

    private List<DataBean> data;

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class StatusBean {
        private int statusCode;
        private String message;
        private String serverTime;

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getServerTime() {
            return serverTime;
        }

        public void setServerTime(String serverTime) {
            this.serverTime = serverTime;
        }
    }

    public static class DataBean {
        private int articleId;
        private int userId;
        private String nickName;
        private String title;
        private String cover;
        private String contentDescribe;
        private String createTime;
        private int type;
        private String shortUrl;
        private int browseNumber;
        private String htmlLocalUrl;
        private String content;

        public int getArticleId() {
            return articleId;
        }

        public void setArticleId(int articleId) {
            this.articleId = articleId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getContentDescribe() {
            return contentDescribe;
        }

        public void setContentDescribe(String contentDescribe) {
            this.contentDescribe = contentDescribe;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getShortUrl() {
            return shortUrl;
        }

        public void setShortUrl(String shortUrl) {
            this.shortUrl = shortUrl;
        }

        public int getBrowseNumber() {
            return browseNumber;
        }

        public void setBrowseNumber(int browseNumber) {
            this.browseNumber = browseNumber;
        }

        public String getHtmlLocalUrl() {
            return htmlLocalUrl;
        }

        public void setHtmlLocalUrl(String htmlLocalUrl) {
            this.htmlLocalUrl = htmlLocalUrl;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
