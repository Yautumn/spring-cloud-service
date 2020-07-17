package com.yautumn.service.communication.impl;

import com.yautumn.common.entity.Communication;
import com.yautumn.common.utils.date.DateUtils;
import com.yautumn.common.utils.poi.ExcelUtils;
import com.yautumn.dao.communication.CommunicationMapper;
import com.yautumn.service.communication.CommunicationService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommunicationServiceImpl implements CommunicationService {
    Logger logger = LoggerFactory.getLogger(CommunicationServiceImpl.class);

    @Autowired
    private CommunicationMapper communicationMapper;

    @Override
    public void readExcel(String fileName) {
        List<Row> rowList = ExcelUtils.readExcel(fileName);
        List<Communication> communicationList = new ArrayList<>();

        rowList.forEach(row -> communicationList.add(convertRowToData(row)));

        //批量入库
        insertBatch(communicationList);
    }

    private void insertBatch(List<Communication> communicationList) {
        int pointLimit = 1000;
        int listSize = communicationList.size();
        int maxSize = listSize - 1;

        List<Communication> communications = new ArrayList<>();
        for (int i = 0; i < communicationList.size(); i++) {
            int count = 0;
            communications.add(communicationList.get(i));
            count++;
            if (pointLimit == communications.size() || count == maxSize){
                communicationMapper.insertForeach(communications);
                communications.clear();
            }
        }
    }

    private Communication convertRowToData(Row row) {
        Communication communication = new Communication();

        Cell cell;
        int cellNum = 0;

        cell = row.getCell(cellNum++);
        String commId = ExcelUtils.convertCellValueToString(cell);
        communication.setCommId(commId);

        cell = row.getCell(cellNum++);
        String contacts = ExcelUtils.convertCellValueToString(cell);
        communication.setContacts(contacts);

        cell = row.getCell(cellNum++);
        String telNum = ExcelUtils.convertCellValueToString(cell);
        communication.setTelNum(telNum);

        cell = row.getCell(cellNum++);
        String did = ExcelUtils.convertCellValueToString(cell);
        communication.setDid(did);

        cell = row.getCell(cellNum++);
        String commChannel = ExcelUtils.convertCellValueToString(cell);
        communication.setCommChannel(commChannel);

        cell = row.getCell(cellNum++);
        String commType = ExcelUtils.convertCellValueToString(cell);
        communication.setCommType(commType);

        cell = row.getCell(cellNum++);
        String commResult = ExcelUtils.convertCellValueToString(cell);
        communication.setCommResult(commResult);

        cell = row.getCell(cellNum++);
        String faultType = ExcelUtils.convertCellValueToString(cell);
        communication.setFaultType(faultType);

        cell = row.getCell(cellNum++);
        String commSign = ExcelUtils.convertCellValueToString(cell);
        communication.setCommSign(commSign);

        cell = row.getCell(cellNum++);
        String satisfaction = ExcelUtils.convertCellValueToString(cell);
        communication.setSatisfaction(satisfaction);

        cell = row.getCell(cellNum++);
        String isSolve = ExcelUtils.convertCellValueToString(cell);
        communication.setIsSolve(isSolve);

        cell = row.getCell(cellNum++);
        Date startDate = cell.getDateCellValue();
        String startTime = DateUtils.dateTimeToString(startDate);
        communication.setStartTime(startTime);

        cell = row.getCell(cellNum++);
        Date endDate = cell.getDateCellValue();
        String endTime = DateUtils.dateTimeToString(endDate);
        communication.setEndTime(endTime);

        cell = row.getCell(cellNum++);
        Integer callTime = Integer.parseInt(ExcelUtils.convertCellValueToString(cell));
        communication.setCallTime(callTime);

        cell = row.getCell(cellNum++);
        String creater = ExcelUtils.convertCellValueToString(cell);
        communication.setCreater(creater);

        cell = row.getCell(cellNum++);
        Date createDate = cell.getDateCellValue();
        String createTime = DateUtils.dateTimeToString(createDate);
        communication.setCreateTime(createTime);

        cell = row.getCell(cellNum++);
        String orderId = ExcelUtils.convertCellValueToString(cell);
        communication.setOrderId(orderId);

        if (null == communication) {
            logger.warn("第 " + row.getRowNum() + "行数据不合法，已忽略！");
        }

        return communication;
    }
}
