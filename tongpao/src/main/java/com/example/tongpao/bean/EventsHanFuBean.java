package com.example.tongpao.bean;

import java.util.List;

public class EventsHanFuBean {
    /**
     * statusCode : 100
     * message : 请求成功！
     * serverTime : 2020-08-19 15:53:39
     */

    private StatusBean status;
    /**
     * hanfuHistoryID : 18
     * userID : 0
     * title : 2002
     * content :
     * contentDescribe : 汉服复兴运动的开端 2002年左右，针对当时人们普遍认为唐装（即满式服装旗袍、马褂）是汉族服装的状况，不少有识之士，力求正本清源，致力于努力恢复满清之前的汉族传
     * type : 0
     * createTime : 2018-09-12 15:16
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
