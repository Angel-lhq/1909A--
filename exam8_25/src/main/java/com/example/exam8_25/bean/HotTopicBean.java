package com.example.exam8_25.bean;

import java.util.List;

public class HotTopicBean {
    /**
     * statusCode : 100
     * message : 请求成功！
     * serverTime : 2020-08-24 21:02:07
     */

    private StatusBean status;
    /**
     * labelId : 499
     * name : 礼衣华夏汉服超模大赛
     * imageUrl : https://tpcdn.whfpsoft.com:443/File/labels/20200731/c50cc9f1da3c1a1bcb0537b270706ae2.png
     * depict : 让华夏审美引领T台时尚，让汉服文化重归大众视野
     * labelTypeName :
     * useTime : 111
     * attentionNum : 52
     * type : 1
     * isAttention : 0
     * createTime :
     * number : 0
     * userID : 0
     * isHot : 0
     * isRecommend : 0
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
        private int labelId;
        private String name;
        private String imageUrl;
        private String depict;
        private String labelTypeName;
        private int useTime;
        private int attentionNum;
        private int type;
        private int isAttention;
        private String createTime;
        private int number;
        private int userID;
        private int isHot;
        private int isRecommend;

        public int getLabelId() {
            return labelId;
        }

        public void setLabelId(int labelId) {
            this.labelId = labelId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getDepict() {
            return depict;
        }

        public void setDepict(String depict) {
            this.depict = depict;
        }

        public String getLabelTypeName() {
            return labelTypeName;
        }

        public void setLabelTypeName(String labelTypeName) {
            this.labelTypeName = labelTypeName;
        }

        public int getUseTime() {
            return useTime;
        }

        public void setUseTime(int useTime) {
            this.useTime = useTime;
        }

        public int getAttentionNum() {
            return attentionNum;
        }

        public void setAttentionNum(int attentionNum) {
            this.attentionNum = attentionNum;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getIsAttention() {
            return isAttention;
        }

        public void setIsAttention(int isAttention) {
            this.isAttention = isAttention;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }

        public int getIsHot() {
            return isHot;
        }

        public void setIsHot(int isHot) {
            this.isHot = isHot;
        }

        public int getIsRecommend() {
            return isRecommend;
        }

        public void setIsRecommend(int isRecommend) {
            this.isRecommend = isRecommend;
        }
    }
}
