package com.yautumn.service.transforeffect.impl;

import com.yautumn.common.entity.TransforEffect;
import com.yautumn.common.utils.poi.ExcelUtils;
import com.yautumn.dao.transforeffect.TransforEffectMapper;
import com.yautumn.service.transforeffect.TransforEffectService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TransforEffectServiceImpl implements TransforEffectService {
    Logger logger = LoggerFactory.getLogger(TransforEffectServiceImpl.class);

    @Autowired
    private TransforEffectMapper transforEffectMapper;

    @Override
    public void readExcel(String fileName) {
        List<Row> rowList = ExcelUtils.readExcel(fileName);
        List<TransforEffect> transforEffectList = new ArrayList<>();

        rowList.forEach(row -> transforEffectList.add(convertRowToData(row)));

        int pointLimit = 1000;
        int listSize = transforEffectList.size();
        int maxSize = listSize - 1;

        List<TransforEffect> transforEffects = new ArrayList<>();
        for (int i = 0; i < transforEffectList.size(); i++) {
            int count = 0;
            transforEffects.add(transforEffectList.get(i));
            count++;
            if (pointLimit == transforEffects.size() || count == maxSize){
                transforEffectMapper.insertForeach(transforEffects);
                transforEffects.clear();
            }
        }

    }

    private TransforEffect convertRowToData(Row row) {
        TransforEffect transforEffect = new TransforEffect();

        Cell cell;
        int cellNum = 0;

        cell = row.getCell(cellNum++);
        String bid = ExcelUtils.convertCellValueToString(cell);
        transforEffect.setBid(bid);

        cell = row.getCell(cellNum++);
        String did = ExcelUtils.convertCellValueToString(cell);
        transforEffect.setDid(did);

        cell = row.getCell(cellNum++);
        String incomingPage = ExcelUtils.convertCellValueToString(cell);
        transforEffect.setIncomingPage(incomingPage);

        cell = row.getCell(cellNum++);
        String incomingEntrance = ExcelUtils.convertCellValueToString(cell);
        transforEffect.setIncomingEntrance(incomingEntrance);

        cell = row.getCell(cellNum++);
        String isNew = ExcelUtils.convertCellValueToString(cell);
        transforEffect.setIsNew(isNew);

        cell = row.getCell(cellNum++);
        Double incomingPosition = cell.getNumericCellValue();
        transforEffect.setIncomingPosition(incomingPosition);

        cell = row.getCell(cellNum++);
        String behavior = ExcelUtils.convertCellValueToString(cell);
        transforEffect.setBehavior(behavior);

        cell = row.getCell(cellNum++);
        String isSuccess = ExcelUtils.convertCellValueToString(cell);
        transforEffect.setIsSuccess(isSuccess);

        cell = row.getCell(cellNum++);
        Integer firstAmount = Integer.parseInt(ExcelUtils.convertCellValueToString(cell));
        transforEffect.setFirstAmount(firstAmount);

        cell = row.getCell(cellNum++);
        Integer totalAmount = Integer.parseInt(ExcelUtils.convertCellValueToString(cell));
        transforEffect.setTotalAmount(totalAmount);

        cell = row.getCell(cellNum++);
        String tIsSuccess = ExcelUtils.convertCellValueToString(cell);
        transforEffect.settIsSuccess(tIsSuccess);

        cell = row.getCell(cellNum++);
        Integer tFirstAmount = Integer.parseInt(ExcelUtils.convertCellValueToString(cell));
        transforEffect.settFirstAmount(tFirstAmount);

        cell = row.getCell(cellNum++);
        String tTotalAmount = ExcelUtils.convertCellValueToString(cell);
        transforEffect.settTotalAmount(tTotalAmount);

        if (null == transforEffect){
            logger.warn("第 " + row.getRowNum() + "行数据不合法，已忽略！");
        }

        return transforEffect;
    }
}
