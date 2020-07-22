package com.yautumn.service.transforeffect.impl;

import com.yautumn.common.entity.TransforEffect;
import com.yautumn.common.reflect.BaseService;
import com.yautumn.common.utils.poi.ExcelUtils;
import com.yautumn.dao.transforeffect.TransforEffectMapper;
import com.yautumn.service.transforeffect.TransforEffectService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransforEffectServiceImpl extends BaseService implements TransforEffectService {
    Logger logger = LoggerFactory.getLogger(TransforEffectServiceImpl.class);

    @Override
    public void readExcel(String fileName) {
        List<Row> rowList = ExcelUtils.readExcel(fileName);
        List<TransforEffect> transforEffectList = new ArrayList<>();

        rowList.forEach(row -> transforEffectList.add(convertRowToData(row)));

        if (!transforEffectList.isEmpty() || transforEffectList.size() != 0){
            super.batch(transforEffectList, TransforEffectMapper.class,"insertForeach");
        }

    }

    private TransforEffect convertRowToData(Row row) {
        TransforEffect transforEffect = new TransforEffect();

        Cell cell;
        int cellNum = 0;

        cell = row.getCell(cellNum++);
        String did = ExcelUtils.convertCellValueToString(cell);
        transforEffect.setDid(did);

        cell = row.getCell(cellNum++);
        String bid = ExcelUtils.convertCellValueToString(cell);
        transforEffect.setBid(bid);

        cell = row.getCell(cellNum++);
        String incomingTime = ExcelUtils.convertCellValueToString(cell);
        transforEffect.setIncomingTime(incomingTime);

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
