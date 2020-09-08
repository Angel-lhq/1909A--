package com.example.exam8_25.bean;

import java.util.List;

public class HotUserBean {
    /**
     * statusCode : 100
     * message : 请求成功！
     * serverTime : 2020-08-24 21:02:08
     */

    private StatusBean status;
    /**
     * id : 380341
     * userID : 380341
     * nickName : 钰惠菇凉
     * headUrl : https://tpcdn.whfpsoft.com:443/File/headPhoto/20200804/f33efc1e1e6a748a9d21eea4517458e8.png
     * age : 1
     * sex :
     * province : 江西
     * city : 赣州
     * level : 1
     * isConcat : 0
     * fileBeanList : [{"filePath":"https://tpcdn.whfpsoft.com:443/File/post/20200804/10e8085c1f7575c7eb12a036b8709b6f.jpg"},{"filePath":"https://tpcdn.whfpsoft.com:443/File/post/20200804/c533bb3768622a93c2d507a014c682bd.jpg"},{"filePath":"https://tpcdn.whfpsoft.com:443/File/post/20200804/4fcf7d7e892a560417c8bc1863818136.jpg"},{"filePath":"https://tpcdn.whfpsoft.com:443/File/post/20200804/37dfbcd769d517559a920a7ee9c25dc4.jpg"},{"filePath":"https://tpcdn.whfpsoft.com:443/File/post/20200804/1226b38fcfdb3db6554893f426ea741b.jpg"},{"filePath":"https://tpcdn.whfpsoft.com:443/File/post/20200804/a29a024ce3a70162e0f6826461fa1079.jpg"},{"filePath":"https://tpcdn.whfpsoft.com:443/File/post/20200804/b20c3589d2cfdd3512063673b37c0bd7.jpg"},{"filePath":"https://tpcdn.whfpsoft.com:443/File/post/20200804/887a643af552652105cdb5a9d5a1ddb5.jpg"},{"filePath":"https://tpcdn.whfpsoft.com:443/File/post/20200804/a2e581e00b658d60ec515e6edfba1b55.jpg"}]
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
         * filePath : https://tpcdn.whfpsoft.com:443/File/post/20200804/10e8085c1f7575c7eb12a036b8709b6f.jpg
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
