package com.example.tongpao.bean;

public class UserLoginBean {

    /**
     * err : 200
     * errmsg :
     * data : {"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImxocSIsInBhc3N3b3JkIjoibGhxMTkwOSIsInVpZCI6ImZhYzUxZjkwLTkzMzQtNDg5Zi04YzZiLWJlM2U4Y2Y1MmNlMiIsImlhdCI6MTU5OTAzNTE0OH0.Yxm5oPa7dNJItx9v_iiMuB0Gz7en8TuWw2TT_K6GzuI","username":"lhq","nickname":null,"avater":"http://yun918.cn/study/public/uploadfiles/1909/crop_IMG_20200629_200408.jpg","phone":"13292119696","uid":"fac51f90-9334-489f-8c6b-be3e8cf52ce2","adress":"北京市  北京市  海淀区","birthday":1630512000,"sex":0,"age":null}
     */

    private int err;
    private String errmsg;
    /**
     * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImxocSIsInBhc3N3b3JkIjoibGhxMTkwOSIsInVpZCI6ImZhYzUxZjkwLTkzMzQtNDg5Zi04YzZiLWJlM2U4Y2Y1MmNlMiIsImlhdCI6MTU5OTAzNTE0OH0.Yxm5oPa7dNJItx9v_iiMuB0Gz7en8TuWw2TT_K6GzuI
     * username : lhq
     * nickname : null
     * avater : http://yun918.cn/study/public/uploadfiles/1909/crop_IMG_20200629_200408.jpg
     * phone : 13292119696
     * uid : fac51f90-9334-489f-8c6b-be3e8cf52ce2
     * adress : 北京市  北京市  海淀区
     * birthday : 1630512000
     * sex : 0
     * age : null
     */

    private DataBean data;

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String token;
        private String username;
        private String nickname;
        private String avater;
        private String phone;
        private String uid;
        private String adress;
        private String birthday;
        private int sex;
        private int age;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvater() {
            return avater;
        }

        public void setAvater(String avater) {
            this.avater = avater;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getAdress() {
            return adress;
        }

        public void setAdress(String adress) {
            this.adress = adress;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
