package com.yautumn.parameter.request.local;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CallDetailRequest {
    //开始时间
    private String startDate;
    //结束时间
    private String endDate;
}
