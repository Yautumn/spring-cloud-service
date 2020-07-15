package com.yautumn.service.loss.impl;

import com.yautumn.common.entity.Loss;
import com.yautumn.common.utils.poi.ExcelUtils;
import com.yautumn.dao.loss.LossMapper;
import com.yautumn.service.loss.LossService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LossServiceImpl implements LossService {

    Logger logger = LoggerFactory.getLogger(LossServiceImpl.class);

    @Autowired
    private LossMapper lossMapper;

    public void readExcel(String fileName) {

        List<Row> rowList = ExcelUtils.readExcel(fileName);
        List<Loss> lossList = new ArrayList<>();
        rowList.forEach(row -> lossList.add(convertRowToData(row)));

        //List<Loss> lossList = ExcelReader.readExcel(fileName);
        int pointLimit = 1000;
        int listSize = lossList.size();
        int maxSize = listSize - 1;
//        List<Loss> lossListNew = lossList.stream().skip(pointLimit).limit(pointLimit).parallel().collect(Collectors.toList());
        List<Loss> lossListNew = new ArrayList<>();
        for (int i = 0; i < lossList.size(); i++) {
            int count = 0;
            lossListNew.add(lossList.get(i));
            count++;
            if (pointLimit == lossListNew.size() || count == maxSize){
                lossMapper.insertForeach(lossListNew);
                lossListNew.clear();
            }
        }
//        lossList.stream().forEach(loss -> insertForeach(loss,pointLimit,maxSize));
    }


    private Loss convertRowToData(Row row) {
        Loss resultData = new Loss();

        Cell cell;
        int cellNum = 0;
        // date_loss
        cell = row.getCell(cellNum++);
        Date date = cell.getDateCellValue();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateLoss = sdf.format(date);
        resultData.setDateLoss(dateLoss);
        // bid
        cell = row.getCell(cellNum++);
        String bid = ExcelUtils.convertCellValueToString(cell);
        resultData.setBid(bid);

        // did
        cell = row.getCell(cellNum++);
        String did = ExcelUtils.convertCellValueToString(cell);
        resultData.setDid(did);
        // userId
        cell = row.getCell(cellNum++);
        String userId = ExcelUtils.convertCellValueToString(cell);
        resultData.setUserId(userId);
        // sex
        cell = row.getCell(cellNum++);
        String sex = ExcelUtils.convertCellValueToString(cell);
        resultData.setSex(sex);
        // userLevel
        cell = row.getCell(cellNum++);
        String userLevel = ExcelUtils.convertCellValueToString(cell);
        resultData.setUserLevel(userLevel);
        // age
        cell = row.getCell(cellNum++);
        String age = ExcelUtils.convertCellValueToString(cell);
        resultData.setAge(age);
        // amount
        cell = row.getCell(cellNum++);
        Double amount = Double.valueOf(ExcelUtils.convertCellValueToString(cell));
        resultData.setAmount(amount);
        // lossPage
        cell = row.getCell(cellNum++);
        String lossPage = ExcelUtils.convertCellValueToString(cell);
        resultData.setLossPage(lossPage);
        // timeLoss
        cell = row.getCell(cellNum++);
        String timeLoss = ExcelUtils.convertCellValueToString(cell);
        resultData.setTimeLoss(timeLoss);
        // prodLoss
        cell = row.getCell(cellNum++);
        String prodLoss = ExcelUtils.convertCellValueToString(cell);
        resultData.setProdLoss(prodLoss);
        // dateline
        cell = row.getCell(cellNum++);
        String dateline = ExcelUtils.convertCellValueToString(cell);
        resultData.setDateline(dateline);
        // rate
        cell = row.getCell(cellNum++);
        String rate = ExcelUtils.convertCellValueToString(cell);
        resultData.setRate(rate);
        // isOpen
        cell = row.getCell(cellNum++);
        String isOpen = ExcelUtils.convertCellValueToString(cell);
        resultData.setIsOpen(isOpen);
        if (null == resultData) {
            logger.warn("第 " + row.getRowNum() + "行数据不合法，已忽略！");
        }
        return resultData;
    }

}
