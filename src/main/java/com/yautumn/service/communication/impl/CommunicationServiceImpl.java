package com.yautumn.service.communication.impl;

import com.yautumn.common.entity.Communication;
import com.yautumn.common.reflect.BaseService;
import com.yautumn.common.utils.date.DateUtils;
import com.yautumn.common.utils.poi.ExcelUtils;
import com.yautumn.dao.communication.CommunicationMapper;
import com.yautumn.service.communication.CommunicationService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommunicationServiceImpl extends BaseService implements CommunicationService {
    Logger logger = LoggerFactory.getLogger(CommunicationServiceImpl.class);

    @Override
    public void readExcel(String fileName) {

        //读取excel文件内容
        List<Row> rowList = ExcelUtils.readExcel(fileName);
        List<Communication> communicationList = new ArrayList<>();

        //将文件内容放入communicationList中
        rowList.forEach(row -> communicationList.add(convertRowToData(row)));

        if (!communicationList.isEmpty() || communicationList.size() != 0){
            super.batch(communicationList, CommunicationMapper.class,"insertForeach");
        }
    }

    /**
     * 将excel内容转化成实体对象；依次获取单元格内容
     * @param row
     * @return
     */
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
        String startDateStr = cell.getStringCellValue();
//        Date startDate = cell.getDateCellValue();
//        String startTime = DateUtils.dateTimeToString(startDate);
        communication.setStartTime(startDateStr);

        cell = row.getCell(cellNum++);
        String endDateStr = cell.getStringCellValue();
//        Date endDate = cell.getDateCellValue();
//        String endTime = DateUtils.dateTimeToString(endDate);
        communication.setEndTime(endDateStr);

        cell = row.getCell(cellNum++);
        if (null != cell.getStringCellValue() && "" != cell.getStringCellValue()) {
            Integer callTime = Integer.parseInt(ExcelUtils.convertCellValueToString(cell));
            communication.setCallTime(callTime);
        }

        cell = row.getCell(cellNum++);
        String creater = ExcelUtils.convertCellValueToString(cell);
        communication.setCreater(creater);

        cell = row.getCell(cellNum++);
        String creatDateStr = cell.getStringCellValue();
//        Date createDate = cell.getDateCellValue();
//        String createTime = DateUtils.dateTimeToString(createDate);
        communication.setCreateTime(creatDateStr);

        cell = row.getCell(cellNum++);
        String orderId = ExcelUtils.convertCellValueToString(cell);
        communication.setOrderId(orderId);

        if (null == communication) {
            logger.warn("第 " + row.getRowNum() + "行数据不合法，已忽略！");
        }

        return communication;
    }
}
