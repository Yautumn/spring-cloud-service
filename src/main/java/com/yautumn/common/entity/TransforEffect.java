package com.yautumn.common.entity;

public class TransforEffect {
    private String bid;

    private String did;

    private String incomingPage;

    private String incomingEntrance;

    private String isNew;

    private Double incomingPosition;

    private String behavior;

    private String isSuccess;

    private Integer firstAmount;

    private Integer totalAmount;

    private String tIsSuccess;

    private Integer tFirstAmount;

    private String tTotalAmount;

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

    public String getIncomingPage() {
        return incomingPage;
    }

    public void setIncomingPage(String incomingPage) {
        this.incomingPage = incomingPage == null ? null : incomingPage.trim();
    }

    public String getIncomingEntrance() {
        return incomingEntrance;
    }

    public void setIncomingEntrance(String incomingEntrance) {
        this.incomingEntrance = incomingEntrance == null ? null : incomingEntrance.trim();
    }

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew == null ? null : isNew.trim();
    }

    public Double getIncomingPosition() {
        return incomingPosition;
    }

    public void setIncomingPosition(Double incomingPosition) {
        this.incomingPosition = incomingPosition;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior == null ? null : behavior.trim();
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess == null ? null : isSuccess.trim();
    }

    public Integer getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(Integer firstAmount) {
        this.firstAmount = firstAmount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String gettIsSuccess() {
        return tIsSuccess;
    }

    public void settIsSuccess(String tIsSuccess) {
        this.tIsSuccess = tIsSuccess == null ? null : tIsSuccess.trim();
    }

    public Integer gettFirstAmount() {
        return tFirstAmount;
    }

    public void settFirstAmount(Integer tFirstAmount) {
        this.tFirstAmount = tFirstAmount;
    }

    public String gettTotalAmount() {
        return tTotalAmount;
    }

    public void settTotalAmount(String tTotalAmount) {
        this.tTotalAmount = tTotalAmount == null ? null : tTotalAmount.trim();
    }
}