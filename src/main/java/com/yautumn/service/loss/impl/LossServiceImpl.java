package com.yautumn.service.loss.impl;

import com.yautumn.common.entity.Loss;
import com.yautumn.common.utils.poi.ExcelUtils;
import com.yautumn.common.reflect.BaseService;
import com.yautumn.dao.loss.LossMapper;
import com.yautumn.service.loss.LossService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class LossServiceImpl extends BaseService implements LossService {

    Logger logger = LoggerFactory.getLogger(LossServiceImpl.class);

    @Value("${fileCreatePath}")
    private String fileCreatePath;

    @Autowired
    private LossMapper lossMapper;

    public void readExcel(String fileName) {

        List<Row> rowList = ExcelUtils.readExcel(fileName);
        List<Loss> lossList = new ArrayList<>();
        rowList.forEach(row -> lossList.add(convertRowToData(row)));

        //批量入库
        if (!lossList.isEmpty() || lossList.size() != 0) {
            super.batch(lossList, LossMapper.class, "insertForeach");
        }
    }

    @Override
    public File writeExcel() {
        //To-Do 从数据库获取数据信息

        LinkedHashMap<String,String> header = new LinkedHashMap<String,String>();
        List results = new ArrayList();
        String fileName = "test";

        //将信息写入Excel
        File file = createExcelFile(results,header,fileCreatePath,fileName);

        return file;
    }

    private File createExcelFile(List results, LinkedHashMap<String, String> header, String fileCreatePath, String fileName) {
        return null;
    }


    private Loss convertRowToData(Row row) {
        Loss resultData = new Loss();

        Cell cell;
        int cellNum = 0;
        // date_loss
        /*cell = row.getCell(cellNum++);
        Date date = cell.getDateCellValue();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateLoss = sdf.format(date);
        resultData.setDateLoss(dateLoss);*/
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
