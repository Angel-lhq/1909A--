package com.example.tongpao.bean;

public class EventsHanFuDetailBean {
    /**
     * statusCode : 100
     * message : 请求成功！
     * serverTime : 2020-08-19 15:54:34
     */

    private StatusBean status;
    /**
     * hanfuHistoryID : 18
     * userID : 100001
     * title : 2002
     * content : <blockquote data-type="backgroundColor" style="word-wrap:break-word; background:#fbf9f7;
     margin:8px 0; padding:8px; border: 1px dashed rgb(182, 182, 182);
     color: rgb(51, 51, 51); line-height: 22px; text-indent: 2em; overflow: hidden;
     font-family: 微软雅黑; font-size: 14px; white-space: normal;"><p style="text-align: center;"><strong>汉服复兴运动的开端</strong></p><p><strong></strong></p><blockquote data-type="backgroundColor" style="margin-top: 8px; margin-bottom: 8px; padding: 8px; font-size: 14px; border: 1px dashed rgb(182, 182, 182); white-space: normal; word-wrap: break-word; background: rgb(251, 249, 247); line-height: 22px; text-indent: 2em; overflow: hidden; font-family: 微软雅黑;"><strong style="text-indent: 2em;">&nbsp;2002年左右，针对当时人们普遍认为唐装（即满式服装旗袍、马褂）是汉族服装的状况，不少有识之士，力求正本清源，致力于努力恢复满清之前的汉族传统服饰的运动。同年2月14日陕西网友华夏血脉在新浪舰船知识网络版军事历史论坛发表了“失落的文明-汉族民族服饰”一帖，两年内点击量达到三十多万并被转贴到海内外多家网站，唤醒了一大批有识之士投身于民间汉服复兴，这标志着现代汉服运动的开始。</strong><br/></blockquote><div><strong>2003年11月22日，民间人士王乐天先生把汉民族的传统服装穿上了街头。“王乐天事件”再次引起大陆各界人士和整个华人世界对中国传统文化和汉民族服饰的关注，影响深远！王乐天穿的这件汉服是由薄绒深衣和茧绸外衣两部分组成，不同于长袍马褂的是，汉服没有纽扣，全部都是系带。这件汉服虽然简陋，甚至有点不合身，却是由王乐天和他的朋友们一针一线缝制的，这帮志同道合的大男人甚至组建了一个工作室，他们查文献，找规制，甚至手脚笨拙地拿起了缝衣针，有人因此刺破了手指，却乐在其中。<br/>&nbsp; &nbsp; &nbsp; &nbsp;尽管有人嘲笑，有人不解，王乐天还是坦然地穿过人群，走在郑州最繁华的街道上。这一行，愈加坚定了他推广汉服的决心，他希望用自己有限的力量去影响他人。很快，网络上出现了很多王乐天身着汉服的照片，那天风很大，他的头发有些乱，但飘逸得充满汉韵古风。新加坡《联合早报》的记者张从兴偶然看到了这些照片，并据此写成了一篇报道，这篇文章也成为第一篇报道汉服的文章，并引起了国内外媒体的广泛关注。王乐天的举动因此广为流传，也得到了很多人的支持响应，并在全国掀起了汉服复兴的浪潮。</strong><br/></div></blockquote>
     * contentDescribe : 汉服复兴运动的开端 2002年左右，针对当时人们普遍认为唐装（即满式服装旗袍、马褂）是汉族服装的状况，不少有识之士，力求正本清源，致力于努力恢复满清之前的汉族传
     * type : 2
     * createTime : 2018-09-12 15:16
     */

    private DataBean data;

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
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
        private int hanfuHistoryID;
        private int userID;
        private String title;
        private String content;
        private String contentDescribe;
        private int type;
        private String createTime;

        public int getHanfuHistoryID() {
            return hanfuHistoryID;
        }

        public void setHanfuHistoryID(int hanfuHistoryID) {
            this.hanfuHistoryID = hanfuHistoryID;
        }

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getContentDescribe() {
            return contentDescribe;
        }

        public void setContentDescribe(String contentDescribe) {
            this.contentDescribe = contentDescribe;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }
    }
}
