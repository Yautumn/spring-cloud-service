package com.yautumn.mapper.resultmap.loss;

import lombok.Getter;
import lombok.Setter;

/**
 * 回呼拨打返回结果映射对象pojo
 */
@Getter
@Setter
public class FallCallBackDetailMap {

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
    private String startTime;

    private Integer callTime;

    /*****星图表数据*****/
    private String incomingPage;

    private String incomingEntrance;

    private String behavior;

    private String isSuccess;

    private String tIsSuccess;
}
