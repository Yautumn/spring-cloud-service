package com.yautumn.common.entity;

public class Robot {
    private String groupId;

    private String product;

    private String comingPage;

    private String createTime;

    private String isScoreRobot;

    private String robotIsSolve;

    private String isArtificial;

    private String artificialIsSolve;

    private String artificialScore;

    private String bid;

    private String userName;

    private String serviceName;

    private String isWorkTime;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public String getComingPage() {
        return comingPage;
    }

    public void setComingPage(String comingPage) {
        this.comingPage = comingPage == null ? null : comingPage.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getIsScoreRobot() {
        return isScoreRobot;
    }

    public void setIsScoreRobot(String isScoreRobot) {
        this.isScoreRobot = isScoreRobot == null ? null : isScoreRobot.trim();
    }

    public String getRobotIsSolve() {
        return robotIsSolve;
    }

    public void setRobotIsSolve(String robotIsSolve) {
        this.robotIsSolve = robotIsSolve == null ? null : robotIsSolve.trim();
    }

    public String getIsArtificial() {
        return isArtificial;
    }

    public void setIsArtificial(String isArtificial) {
        this.isArtificial = isArtificial == null ? null : isArtificial.trim();
    }

    public String getArtificialIsSolve() {
        return artificialIsSolve;
    }

    public void setArtificialIsSolve(String artificialIsSolve) {
        this.artificialIsSolve = artificialIsSolve == null ? null : artificialIsSolve.trim();
    }

    public String getArtificialScore() {
        return artificialScore;
    }

    public void setArtificialScore(String artificialScore) {
        this.artificialScore = artificialScore == null ? null : artificialScore.trim();
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid == null ? null : bid.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public String getIsWorkTime() {
        return isWorkTime;
    }

    public void setIsWorkTime(String isWorkTime) {
        this.isWorkTime = isWorkTime == null ? null : isWorkTime.trim();
    }
}