package com.yautumn.mapper.resultmap.active;

import lombok.Getter;
import lombok.Setter;

/**
 * 主动进线返回结果映射对象pojo
 */
@Getter
@Setter
public class CallDetailMap {

    /*****工单表数据*****/
    private String orderId;

    private String did;

    private String event1;

    private String event2;

    private String event3;

    private String event4;

    private String event5;

    private String creatJob;

    private String creater;

    private String createTime;

    private String level;

    /*****沟通表数据*****/
    private String commId;

    private String cCreater;

    private String startTime;

    private Integer callTime;

    /*****星图表数据*****/
    private String incomingPage;

    private String incomingEntrance;

    private String behavior;

    private String isSuccess;

    private String tIsSuccess;

    @Override
    public String toString() {
        return "CallDetailMap{" +
                "orderId='" + orderId + '\'' +
                ", did='" + did + '\'' +
                ", event1='" + event1 + '\'' +
                ", event2='" + event2 + '\'' +
                ", event3='" + event3 + '\'' +
                ", event4='" + event4 + '\'' +
                ", event5='" + event5 + '\'' +
                ", creatJob='" + creatJob + '\'' +
                ", creater='" + creater + '\'' +
                ", createTime='" + createTime + '\'' +
                ", level='" + level + '\'' +
                ", commId='" + commId + '\'' +
                ", cCreater='" + cCreater + '\'' +
                ", startTime='" + startTime + '\'' +
                ", callTime=" + callTime +
                ", incomingPage='" + incomingPage + '\'' +
                ", incomingEntrance='" + incomingEntrance + '\'' +
                ", behavior='" + behavior + '\'' +
                ", isSuccess='" + isSuccess + '\'' +
                ", tIsSuccess='" + tIsSuccess + '\'' +
                '}';
    }
}
