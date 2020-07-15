package com.yautumn.service.loss.impl;

import com.yautumn.common.entity.Loss;
import com.yautumn.common.utils.poi.ExcelReader;
import com.yautumn.dao.loss.LossMapper;
import com.yautumn.service.loss.LossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LossServiceImpl implements LossService {

    @Autowired
    private LossMapper lossMapper;

    public void readExcel(String fileName) {
        List<Loss> lossList = ExcelReader.readExcel(fileName);
        int pointLimit = 1000;
        int listSize = lossList.size();
        int maxSize = listSize - 1;
        lossList.stream().forEach(loss -> insertForeach(loss,pointLimit,maxSize));
    }

    private void insertForeach(Loss loss, int pointLimit, int maxSize) {
        int count = 0;
        List<Loss> lossListNew = new ArrayList<>();
        lossListNew.add(loss);
        count++;
        if (pointLimit == lossListNew.size() || count == maxSize){
            lossMapper.insertForeach(lossListNew);
            lossListNew.clear();
        }
    }
}
