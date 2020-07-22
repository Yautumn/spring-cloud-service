package com.yautumn.service.excel;

import com.yautumn.mapper.resultmap.active.CallDetailMap;
import com.yautumn.parameter.request.local.CallDetailRequest;

import java.util.List;

public interface ExcelService {
    List<CallDetailMap> getCallDetail(CallDetailRequest param);
}
