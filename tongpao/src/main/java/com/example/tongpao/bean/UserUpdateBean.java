package com.example.tongpao.bean;

public class UserUpdateBean {

    /**
     * err : 200
     * errmsg : 成功
     * data : {"type":1}
     *       if(avater){
     *         info.avater = avater;
     *         obj.data.type = 1;
     *       }
     *       if(phone){
     *         info.phone = phone;
     *         obj.data.type = 2;
     *       }
     *       if(nickname){
     *         info.nickname = nickname;
     *         info.data.type = 3;
     *       }
     *       if(sex){
     *         info.sex = sex;
     *         info.data.type = 4;
     *       }
     *       if(sign){
     *         info.sign = sign;
     *         info.data.type = 5;
     *       }
     *       if(age){
     *         info.age = age;
     *         info.data.type = 6;
     *       }
     *       if(birthday){
     *         info.birthday = birthday;
     *         info.data.type = 7;
     *       }
     *       if(adress){
     *         info.adress = adress;
     *         info.data.type = 8;
     *       }
     */

    private int err;
    private String errmsg;
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
        /**
         * type : 1
         */

        private int type;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
