package com.example.tongpao.bean;

import java.util.List;

public class AboutHanFuBean {
    /**
     * statusCode : 100
     * message : 请求成功！
     * serverTime : 2020-08-19 15:23:46
     */

    private StatusBean status;
    /**
     * articleId : 192
     * userId : 100001
     * nickName : 官方小袍
     * title : 汉服配饰 | 除了颜值加分，抹额这些妙用你知道吗？
     * cover : https://tpcdn.whfpsoft.com:443/File/article/20200727/c2d5ea0eb24127a7933f23cc7cbec378.jpg
     * contentDescribe : 若论起过去的2019年 最火的电视剧有哪些 那《陈情令》必然拥有姓名 剧里的道具“抹额”起到了重要的装饰作用 古装剧的服化道自然跟历史会有差别 古代的抹额类好物 除了装饰外还有不少作用哦~ 抹额—军人的必备好物 在唐代时，抹额经常出现在武士的额头上。唐章怀太子墓的壁画上，就出现了头戴红色抹额的武士。 △唐章怀太子墓壁画 在当时的文字记载里，已经出现了“抹额”这一词。中唐诗人李贺曾作过一首诗《画角东城》，描绘水军操演的情形：“水花沾抹额，旗鼓夜迎潮。” 五代时《中华古今注》中就有“军容抹额”条款，当时军中以不同颜色的抹额作为标识，以此区分不同的军队。《资治通鉴》卷二一五“玄宗天宝二年”条：“陕尉
     * createTime : 2020-07-27 15:17
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
