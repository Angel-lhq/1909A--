package com.example.tongpao.bean;

import java.util.List;

public class HotTopicBean {
    /**
     * statusCode : 100
     * message : 请求成功！
     * serverTime : 2020-08-04 13:41:10
     */

    private StatusBean status;
    /**
     * labelId : 44
     * name : 飞花令
     * imageUrl : https://tpcdn.whfpsoft.com:443/File/labels/20190704/748df09273484512c55c8e0a1a1d9ed5.png
     * depict : 飞花令，原本是古人行酒令时的一个文字游戏，源自古人的诗词之趣，现代经过改良，也变得更加具有趣味性，我们也来玩儿一玩儿飞花令吧~
     * labelTypeName :
     * useTime : 351
     * attentionNum : 278
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
