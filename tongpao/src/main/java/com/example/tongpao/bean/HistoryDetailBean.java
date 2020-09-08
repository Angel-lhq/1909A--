package com.example.tongpao.bean;

public class HistoryDetailBean {
    /**
     * statusCode : 100
     * message : 请求成功！
     * serverTime : 2020-08-19 15:33:19
     */

    private StatusBean status;
    /**
     * hanfuHistoryID : 25
     * userID : 100001
     * title : 汉服
     * content : <section class="_wxbEditor"><section style="text-align: center;padding:0.5em;"><section style="width:100%;display:inline-block;"><section style="text-align: right;margin-bottom: -22px;margin-right:20px;transform:rotate(0deg);"><section style="display: inline-block;background: rgb(255,255,255);padding: 0px 3px;"><section style="display: flex;justify-content: flex-start;"><section style="width:0.8em;"><img src="http://mmbiz-qpic-cn.weituibao.com/mmbiz_png/oMlX8Lll9JiaZJjgmuRHQb36BqCegnicRNH0MgMiaIRdZCxhXvyfK8AEa5HNPb1CFR55mOrRTZKvfAOvs7tI8IQPw/0" style="width: 100%;display: block;"/></section><section style="width:0.8em;margin: 0px 5px;"><img src="http://mmbiz-qpic-cn.weituibao.com/mmbiz_png/oMlX8Lll9JiaZJjgmuRHQb36BqCegnicRNH0MgMiaIRdZCxhXvyfK8AEa5HNPb1CFR55mOrRTZKvfAOvs7tI8IQPw/0" style="width: 100%;display: block;"/></section><section style="width:0.8em;"><img src="http://mmbiz-qpic-cn.weituibao.com/mmbiz_png/oMlX8Lll9JiaZJjgmuRHQb36BqCegnicRNH0MgMiaIRdZCxhXvyfK8AEa5HNPb1CFR55mOrRTZKvfAOvs7tI8IQPw/0" style="width: 100%;display: block;"/></section></section></section></section><section style="width:100%;border-radius:15px;padding:8px;box-shadow: 0px 0px 15px rgb(211,211,211);"><section style="border: 1px dashed #333;border-radius:10px;"><section style="padding:1em;font-size: 14px;text-align: justify;letter-spacing: 1.5px;line-height: 1.75em;color:#333;"><div id="baikecard" data-sub="#4990915-5214683-0" style="padding-top: 20px; padding-right: 30px; padding-left: 30px; color: rgb(0, 0, 0); font-family: arial, sans-serif; font-size: 12px; white-space: normal;"><div class="card_content" id="js-card-content" style="color: rgb(51, 51, 51); font-size: 14px; line-height: 24px;"><p style="margin-top: 0px; margin-bottom: 15px; line-height: 24px; text-indent: 2em;"><strong>汉服</strong>，全称是“汉民族传统服饰”，又称汉衣冠、汉装、华服，是从黄帝即位到公元17世纪中叶<em>（明末清初）</em>，在汉族的主要居住区，以“华夏－汉”文化为背景和主导思想，以华夏礼仪文化为中心，通过自然演化而形成的具有独特汉民族风貌性格，明显区别于其他民族的传统服装和配饰体系，是中国“衣冠上国”、“礼仪之邦”、“锦绣中华”、赛里斯国的体现，承载了汉族的染织绣等杰出工艺和美学，传承了30多项中国非物质文化遗产以及受保护的中国工艺美术。</p><p style="margin-top: 0px; margin-bottom: 15px; line-height: 24px; text-indent: 2em;">与汉人一词类似，汉服中的“汉”字的词义外延亦存在着由汉朝扩大为整个民族指称的过程。如《马王堆三号墓遣册》关于“汉服”最早的记载：“简四四‘美人四人，其二人楚服，二人汉服’”中的“汉服”是指汉朝的服饰礼仪制度，即《周礼》《仪礼》《礼记》里的冠服体系。</p><p style="margin-top: 0px; margin-bottom: 15px; line-height: 24px; text-indent: 2em;">汉服“始于黄帝，备于尧舜” ，源自黄帝制冕服。定型于周朝，并通过汉朝依据四书五经形成完备的冠服体系，成为神道设教的一部分。因此后来各个华夏朝代均宗周法汉以继承汉衣冠为国家大事，于是有了二十四史中的舆服志。“黄帝、尧、舜垂衣裳而治天下，益取自乾坤”，是说上衣下裳的形制是取天意而定，是神圣的。汉服还通过华夏法系影响了整个汉文化圈，亚洲各国的部分民族如日本、朝鲜、越南、蒙古、不丹等等服饰均具有或借鉴汉服特征。</p></div><div class="intro_button"></div></div><div class="starVideo starVideo1" id="starVideo" style="margin-right: 30px; margin-left: 30px; color: rgb(0, 0, 0); font-family: arial, sans-serif; font-size: 12px; white-space: normal;"></div><p><br/></p></section></section></section></section></section></section><p><br/></p><p><br/></p>
     * contentDescribe : 汉服，全称是“汉民族传统服饰”，又称汉衣冠、汉装、华服，是从黄帝即位到公元17世纪中叶（明末清初），在汉族的主要居住区，以“华夏－汉”文化为背景和主导思想，以华
     * type : 1
     * createTime : 2020-08-12 10:37
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
