package com.yautumn.common.entity;

public class Loss {
    private Integer id;

    private String dateLoss;

    private String bid;

    private String did;

    private String userId;

    private String sex;

    private String userLevel;

    private String age;

    private Double amount;

    private String lossPage;

    private String timeLoss;

    private String prodLoss;

    private String dateline;

    private String rate;

    private String isOpen;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateLoss() {
        return dateLoss;
    }

    public void setDateLoss(String dateLoss) {
        this.dateLoss = dateLoss == null ? null : dateLoss.trim();
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid == null ? null : bid.trim();
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did == null ? null : did.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel == null ? null : userLevel.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getLossPage() {
        return lossPage;
    }

    public void setLossPage(String lossPage) {
        this.lossPage = lossPage == null ? null : lossPage.trim();
    }

    public String getTimeLoss() {
        return timeLoss;
    }

    public void setTimeLoss(String timeLoss) {
        this.timeLoss = timeLoss == null ? null : timeLoss.trim();
    }

    public String getProdLoss() {
        return prodLoss;
    }

    public void setProdLoss(String prodLoss) {
        this.prodLoss = prodLoss == null ? null : prodLoss.trim();
    }

    public String getDateline() {
        return dateline;
    }

    public void setDateline(String dateline) {
        this.dateline = dateline == null ? null : dateline.trim();
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate == null ? null : rate.trim();
    }

    public String getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen == null ? null : isOpen.trim();
    }
}