package com.yautumn.common.entity;

public class UserDid {
    private String fDid;

    public String getfDid() {
        return fDid;
    }

    public void setfDid(String fDid) {
        this.fDid = fDid == null ? null : fDid.trim();
    }
}