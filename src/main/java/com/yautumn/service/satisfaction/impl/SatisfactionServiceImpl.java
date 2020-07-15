package com.yautumn.service.satisfaction.impl;

import com.yautumn.common.entity.Satisfaction;
import com.yautumn.common.utils.poi.ExcelUtils;
import com.yautumn.dao.satisfaction.SatisfactionMapper;
import com.yautumn.service.satisfaction.SatisfactionService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SatisfactionServiceImpl implements SatisfactionService {

    @Autowired
    private SatisfactionMapper satisfactionMapper;

    @Override
    public void readExcel(String fileName) {
        List<Row> rowList = ExcelUtils.readExcel(fileName);
        List<Satisfaction> satisfactionList = new ArrayList<>();

        rowList.forEach(row -> satisfactionList.add(convertRowToData(row)));

        int pointLimit = 1000;
        int listSize = satisfactionList.size();
        int maxSize = listSize - 1;

        List<Satisfaction> satisfactions = new ArrayList<>();
        for (int i = 0; i < satisfactionList.size(); i++) {
            int count = 0;
            satisfactions.add(satisfactionList.get(i));
            count++;
            if (pointLimit == satisfactions.size() || count == maxSize){
                satisfactionMapper.insertForeach(satisfactions);
                satisfactions.clear();
            }
        }
    }

    private Satisfaction convertRowToData(Row row) {

        Satisfaction satisfactions = new Satisfaction();

        Cell cell;
        int cellNum = 0;

        cell = row.getCell(cellNum++);
        String dateTime = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setDateTime(dateTime);

        cell = row.getCell(cellNum++);
        String productLine = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setProductLine(productLine);

        cell = row.getCell(cellNum++);
        String comeFrom = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setComeFrom(comeFrom);

        cell = row.getCell(cellNum++);
        String event1 = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setEvent1(event1);

        cell = row.getCell(cellNum++);
        String event2 = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setEvent2(event2);

        cell = row.getCell(cellNum++);
        String event3 = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setEvent3(event3);

        cell = row.getCell(cellNum++);
        String event4 = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setEvent4(event4);

        cell = row.getCell(cellNum++);
        String event5 = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setEvent5(event5);

        cell = row.getCell(cellNum++);
        String commId = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setCommId(commId);

        cell = row.getCell(cellNum++);
        String orderId = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setOrderId(orderId);

        cell = row.getCell(cellNum++);
        String employee = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setEmployee(employee);

        cell = row.getCell(cellNum++);
        String quesstionDesc = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setQuesstionDesc(quesstionDesc);

        cell = row.getCell(cellNum++);
        String resolve = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setResolve(resolve);

        cell = row.getCell(cellNum++);
        String isForward = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setIsForward(isForward);

        cell = row.getCell(cellNum++);
        String satisfaction = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setSatisfaction(satisfaction);

        cell = row.getCell(cellNum++);
        String isResolve = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setIsResolve(isResolve);

        cell = row.getCell(cellNum++);
        String bid = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setBid(bid);

        cell = row.getCell(cellNum++);
        String telNum = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setTelNum(telNum);

        cell = row.getCell(cellNum++);
        String walletId = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setWalletId(walletId);

        cell = row.getCell(cellNum++);
        String priority = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setPriority(priority);

        cell = row.getCell(cellNum++);
        String urgeTimes = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setUrgeTimes(urgeTimes);

        cell = row.getCell(cellNum++);
        String commChannel = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setCommChannel(commChannel);

        cell = row.getCell(cellNum++);
        String incoming = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setIncoming(incoming);

        cell = row.getCell(cellNum++);
        String isInviteEvaluate = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setIsInviteEvaluate(isInviteEvaluate);

        cell = row.getCell(cellNum++);
        String forwardProductLine = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setForwardProductLine(forwardProductLine);

        cell = row.getCell(cellNum++);
        String bid24 = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setBid24(bid24);

        cell = row.getCell(cellNum++);
        String bid48 = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setBid48(bid48);

        cell = row.getCell(cellNum++);
        String mobile24 = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setMobile24(mobile24);

        cell = row.getCell(cellNum++);
        String mobile48 = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setMobile48(mobile48);

        cell = row.getCell(cellNum++);
        String commType = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setCommType(commType);

        cell = row.getCell(cellNum++);
        String isUpdate = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setIsUpdate(isUpdate);

        cell = row.getCell(cellNum++);
        String createPost = ExcelUtils.convertCellValueToString(cell);
        satisfactions.setCreatePost(createPost);

        return satisfactions;
    }
}
