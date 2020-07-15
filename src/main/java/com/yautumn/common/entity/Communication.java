package com.yautumn.common.entity;

public class Communication {
    private String commId;

    private String contacts;

    private String telNum;

    private String did;

    private String commChannel;

    private String commType;

    private String commResult;

    private String faultType;

    private String commSign;

    private String satisfaction;

    private String isSolve;

    private String startTime;

    private String endTime;

    private Integer callTime;

    private String creater;

    private String createTime;

    private String orderId;

    public String getCommId() {
        return commId;
    }

    public void setCommId(String commId) {
        this.commId = commId == null ? null : commId.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum == null ? null : telNum.trim();
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did == null ? null : did.trim();
    }

    public String getCommChannel() {
        return commChannel;
    }

    public void setCommChannel(String commChannel) {
        this.commChannel = commChannel == null ? null : commChannel.trim();
    }

    public String getCommType() {
        return commType;
    }

    public void setCommType(String commType) {
        this.commType = commType == null ? null : commType.trim();
    }

    public String getCommResult() {
        return commResult;
    }

    public void setCommResult(String commResult) {
        this.commResult = commResult == null ? null : commResult.trim();
    }

    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType == null ? null : faultType.trim();
    }

    public String getCommSign() {
        return commSign;
    }

    public void setCommSign(String commSign) {
        this.commSign = commSign == null ? null : commSign.trim();
    }

    public String getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(String satisfaction) {
        this.satisfaction = satisfaction == null ? null : satisfaction.trim();
    }

    public String getIsSolve() {
        return isSolve;
    }

    public void setIsSolve(String isSolve) {
        this.isSolve = isSolve == null ? null : isSolve.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Integer getCallTime() {
        return callTime;
    }

    public void setCallTime(Integer callTime) {
        this.callTime = callTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }
}