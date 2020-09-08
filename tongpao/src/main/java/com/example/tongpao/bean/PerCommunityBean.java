package com.example.tongpao.bean;

import java.util.List;

public class PerCommunityBean {
    /**
     * statusCode : 100
     * message : 请求成功！
     * serverTime : 2020-08-08 16:23:05
     */

    private StatusBean status;
    /**
     * accountId : 0
     * accountName :
     * accountUserName :
     * loginType : 0
     * accountType : 0
     * userID : 0
     * trueName :
     * idCardNo :
     * orgID : 100004
     * chart : 0
     * nickName :
     * phone :
     * countUser : 37
     * countActivity : 2
     * isExist : 0
     * logo : https://tpcdn.whfpsoft.com:443/File/tim/100005/100005/20181008/25fc131cf596f6eee8033fa24f1e59d1.jpg
     * fullName : 子衿汉服社
     * shortName :
     * type : 学校
     * province : 湖北
     * city : 武汉
     * note : 子衿汉服社秉承着“着我汉家衣裳，兴我礼仪之邦”的理念，热爱传统服饰，热爱汉家文化，为有民族责任心的武汉学子提供契机，我们传承汉服文化，捍卫属于我们自己的衣冠与礼仪精神。
     * attachment : https://tpcdn.whfpsoft.com:443/File/tim/100005/100005/20180828/419007f30f23e0f337c47c42cbafcb30.jpg,https://tpcdn.whfpsoft.com:443/File/tim/100005/100005/20180828/43a44b91fd318dc8f9d5519a7b806f5f.jpg,https://tpcdn.whfpsoft.com:443/File/tim/100005/100005/20180828/b84833c4157f68cdfe2e59cabd618783.jpg
     * createuserid : 100005
     * integralnumber : 421
     * announcement : 欢迎小伙伴们加入子衿汉服社👏 👏 👏
     * managementType : 0
     * createtime : 2018-08-28 10:46:36
     * status : 1
     * isJoin : 0
     * rank : 1
     * depict : 子衿汉服社
     * balance : 0
     * monthIntegrall : 0
     * state : 2
     * idnumberImage :
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
        private int accountId;
        private String accountName;
        private String accountUserName;
        private int loginType;
        private int accountType;
        private int userID;
        private String trueName;
        private String idCardNo;
        private int orgID;
        private int chart;
        private String nickName;
        private String phone;
        private int countUser;
        private int countActivity;
        private int isExist;
        private String logo;
        private String fullName;
        private String shortName;
        private String type;
        private String province;
        private String city;
        private String note;
        private String attachment;
        private int createuserid;
        private int integralnumber;
        private String announcement;
        private int managementType;
        private String createtime;
        private int status;
        private int isJoin;
        private int rank;
        private String depict;
        private int balance;
        private int monthIntegrall;
        private int state;
        private String idnumberImage;

        public int getAccountId() {
            return accountId;
        }

        public void setAccountId(int accountId) {
            this.accountId = accountId;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public String getAccountUserName() {
            return accountUserName;
        }

        public void setAccountUserName(String accountUserName) {
            this.accountUserName = accountUserName;
        }

        public int getLoginType() {
            return loginType;
        }

        public void setLoginType(int loginType) {
            this.loginType = loginType;
        }

        public int getAccountType() {
            return accountType;
        }

        public void setAccountType(int accountType) {
            this.accountType = accountType;
        }

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }

        public String getTrueName() {
            return trueName;
        }

        public void setTrueName(String trueName) {
            this.trueName = trueName;
        }

        public String getIdCardNo() {
            return idCardNo;
        }

        public void setIdCardNo(String idCardNo) {
            this.idCardNo = idCardNo;
        }

        public int getOrgID() {
            return orgID;
        }

        public void setOrgID(int orgID) {
            this.orgID = orgID;
        }

        public int getChart() {
            return chart;
        }

        public void setChart(int chart) {
            this.chart = chart;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getCountUser() {
            return countUser;
        }

        public void setCountUser(int countUser) {
            this.countUser = countUser;
        }

        public int getCountActivity() {
            return countActivity;
        }

        public void setCountActivity(int countActivity) {
            this.countActivity = countActivity;
        }

        public int getIsExist() {
            return isExist;
        }

        public void setIsExist(int isExist) {
            this.isExist = isExist;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getShortName() {
            return shortName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getAttachment() {
            return attachment;
        }

        public void setAttachment(String attachment) {
            this.attachment = attachment;
        }

        public int getCreateuserid() {
            return createuserid;
        }

        public void setCreateuserid(int createuserid) {
            this.createuserid = createuserid;
        }

        public int getIntegralnumber() {
            return integralnumber;
        }

        public void setIntegralnumber(int integralnumber) {
            this.integralnumber = integralnumber;
        }

        public String getAnnouncement() {
            return announcement;
        }

        public void setAnnouncement(String announcement) {
            this.announcement = announcement;
        }

        public int getManagementType() {
            return managementType;
        }

        public void setManagementType(int managementType) {
            this.managementType = managementType;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getIsJoin() {
            return isJoin;
        }

        public void setIsJoin(int isJoin) {
            this.isJoin = isJoin;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getDepict() {
            return depict;
        }

        public void setDepict(String depict) {
            this.depict = depict;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public int getMonthIntegrall() {
            return monthIntegrall;
        }

        public void setMonthIntegrall(int monthIntegrall) {
            this.monthIntegrall = monthIntegrall;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getIdnumberImage() {
            return idnumberImage;
        }

        public void setIdnumberImage(String idnumberImage) {
            this.idnumberImage = idnumberImage;
        }
    }
}
