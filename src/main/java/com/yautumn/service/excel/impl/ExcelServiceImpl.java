package com.yautumn.service.excel.impl;

import com.yautumn.common.utils.poi.ExcelWriter;
import com.yautumn.dao.order.OrderMapper;
import com.yautumn.mapper.resultmap.active.CallDetailMap;
import com.yautumn.parameter.request.local.CallDetailRequest;
import com.yautumn.service.excel.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Value("${fileCreatePath}")
    private String fileCreatePath;

    @Autowired
    private OrderMapper orderMapper;

    public List<CallDetailMap> getCallDetail(CallDetailRequest param){
        //从数据库中查询要导出的数据
        List<CallDetailMap> callDetailMapList = orderMapper.callDetail(param);

        List columnNames = getCallDetailTitle();

        List<List<Object>> dataList = new ArrayList<>();
        //添加导出表头
        dataList.add(columnNames);
        //添加导出数据
        traverse(dataList,callDetailMapList);
        try {
            ExcelWriter.writeExcelData(fileCreatePath,"testFile","sheetName",dataList,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //对所要导出的表头以及内容处理
    private List<List<Object>> traverse(List<List<Object>> dataList, List<CallDetailMap> callDetailMapList) {
        callDetailMapList.stream().forEach(callDetailMap -> dataList.add(traverse(callDetailMap)));
        return dataList;
    }

    //处理导出内容数据
    private List<Object> traverse(CallDetailMap callDetailMap) {
        List<Object> list = new ArrayList<>();
        list.add(callDetailMap.getOrderId());
        list.add(callDetailMap.getDid());
        list.add(callDetailMap.getEvent1());
        list.add(callDetailMap.getEvent2());
        list.add(callDetailMap.getEvent3());
        list.add(callDetailMap.getEvent4());
        if (null == callDetailMap.getEvent5() || "".equals(callDetailMap.getEvent5())){
            if (null == callDetailMap.getEvent4() || "".equals(callDetailMap.getEvent4())){
                if (null == callDetailMap.getEvent3() || "".equals(callDetailMap.getEvent3())){
                    if (null == callDetailMap.getEvent2() || "".equals(callDetailMap.getEvent2())){
                        callDetailMap.setEvent5(callDetailMap.getEvent1());
                    }else {
                        callDetailMap.setEvent5(callDetailMap.getEvent2());
                    }
                }else {
                    callDetailMap.setEvent5(callDetailMap.getEvent3());
                }
            }
            else {
                callDetailMap.setEvent5(callDetailMap.getEvent4());
            }
        }
        list.add(callDetailMap.getEvent5());
        list.add(callDetailMap.getCreatJob());
        list.add(callDetailMap.getCreater());
        list.add(callDetailMap.getCreateTime());
        list.add(callDetailMap.getLevel());
        if (null == callDetailMap.getCommId()){
            list.add("未升级");
        }else {
            list.add("升级");
        }
        list.add(callDetailMap.getCCreater());
        if (null == callDetailMap.getCallTime()){
            list.add("未接通");
            list.add("");
        }else {
            list.add("已接通");
            list.add(callDetailMap.getStartTime());
        }
        list.add(callDetailMap.getIncomingPage());
        list.add(callDetailMap.getIncomingEntrance());
        list.add(callDetailMap.getBehavior());
        list.add(callDetailMap.getIsSuccess());
        list.add(callDetailMap.getTIsSuccess());
        if (("-".equals(callDetailMap.getIncomingPage())
                    && !"-".equals(callDetailMap.getBehavior()))
                || (!"产品详情页".equals(callDetailMap.getIncomingPage())
                    && (!"-".equals(callDetailMap.getBehavior())
                    || !"产品详情页".equals(callDetailMap.getBehavior())))
                || (!"申购详情页".equals(callDetailMap.getIncomingPage())
                    && (!"-".equals(callDetailMap.getBehavior())
                    || !"申购详情页".equals(callDetailMap.getBehavior())))){
            list.add("转化");
        }else {
            list.add("未转化");
        }
        return list;
    }

    private List getCallDetailTitle() {
        List columnNames = new ArrayList();
        columnNames.add("工单id");
        columnNames.add("度小满ID");
        columnNames.add("事件类型1");
        columnNames.add("事件类型2");
        columnNames.add("事件类型3");
        columnNames.add("事件类型4");
        columnNames.add("事件类型5");
        columnNames.add("创建岗位");
        columnNames.add("创建人");
        columnNames.add("创建时间");
        columnNames.add("理财等级");
        columnNames.add("是否升级");
        columnNames.add("拨打人");
        columnNames.add("是否接通");
        columnNames.add("开始时间");
        columnNames.add("进线页面");
        columnNames.add("进线入口");
        columnNames.add("进线当日最深行为");
        columnNames.add("T日是否转化");
        columnNames.add("T+7是否转化");
        columnNames.add("下一步是否转化");

        return columnNames;
    }

}
