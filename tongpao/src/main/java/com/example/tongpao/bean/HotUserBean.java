package com.example.tongpao.bean;

import java.util.List;

public class HotUserBean {
    /**
     * statusCode : 100
     * message : 请求成功！
     * serverTime : 2020-08-04 13:41:11
     */

    private StatusBean status;
    /**
     * id : 304393
     * userID : 304393
     * nickName : 袍哥科普笔记
     * headUrl : https://tpcdn.whfpsoft.com:443/File/headPhoto/20200422/9f1a5f136037ca8e889741a0fae40958.jpg
     * age : 28
     * sex : 0
     * province : 湖北
     * city : 武汉
     * level : 3
     * isConcat : 0
     * fileBeanList : [{"filePath":"https://tpcdn.whfpsoft.com:443/File/post/20200802/5614cbe79ce44655069639c0c0d96c99.jpg"},{"filePath":"https://tpcdn.whfpsoft.com:443/File/post/20200802/05891f00a39f9fe5f3551d468f0fc4af.jpg"},{"filePath":"https://tpcdn.whfpsoft.com:443/File/post/20200802/057438b900f87a3babf6cbc4bad51442.jpg"},{"filePath":"https://tpcdn.whfpsoft.com:443/File/post/20200802/114f0fe408518c0866e74e513a563c06.jpg"},{"filePath":"https://tpcdn.whfpsoft.com:443/File/post/20200802/e747db4cbfc0951de55ac871e9b07aa6.jpg"}]
     * socialTitle :
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
        private int id;
        private int userID;
        private String nickName;
        private String headUrl;
        private int age;
        private String sex;
        private String province;
        private String city;
        private int level;
        private int isConcat;
        private String socialTitle;
        /**
         * filePath : https://tpcdn.whfpsoft.com:443/File/post/20200802/5614cbe79ce44655069639c0c0d96c99.jpg
         */

        private List<FileBeanListBean> fileBeanList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getHeadUrl() {
            return headUrl;
        }

        public void setHeadUrl(String headUrl) {
            this.headUrl = headUrl;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getIsConcat() {
            return isConcat;
        }

        public void setIsConcat(int isConcat) {
            this.isConcat = isConcat;
        }

        public String getSocialTitle() {
            return socialTitle;
        }

        public void setSocialTitle(String socialTitle) {
            this.socialTitle = socialTitle;
        }

        public List<FileBeanListBean> getFileBeanList() {
            return fileBeanList;
        }

        public void setFileBeanList(List<FileBeanListBean> fileBeanList) {
            this.fileBeanList = fileBeanList;
        }

        public static class FileBeanListBean {
            private String filePath;

            public String getFilePath() {
                return filePath;
            }

            public void setFilePath(String filePath) {
                this.filePath = filePath;
            }
        }
    }
}
