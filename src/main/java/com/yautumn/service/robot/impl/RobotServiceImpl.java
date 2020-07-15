package com.yautumn.service.robot.impl;

import com.yautumn.common.entity.Robot;
import com.yautumn.common.utils.poi.ExcelUtils;
import com.yautumn.dao.robot.RobotMapper;
import com.yautumn.service.robot.RobotService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RobotServiceImpl implements RobotService {
    Logger logger = LoggerFactory.getLogger(RobotServiceImpl.class);

    @Autowired
    private RobotMapper robotMapper;

    @Override
    public void readExcel(String fileName) {
        List<Row> rowList = ExcelUtils.readExcel(fileName);
        List<Robot> robotList = new ArrayList<>();

        rowList.forEach(row -> robotList.add(convertRowToData(row)));

        int pointLimit = 1000;
        int listSize = robotList.size();
        int maxSize = listSize - 1;

        List<Robot> robots = new ArrayList<>();
        for (int i = 0; i < robotList.size(); i++) {
            int count = 0;
            robots.add(robotList.get(i));
            count++;
            if (pointLimit == robots.size() || count == maxSize){
                robotMapper.insertForeach(robots);
                robots.clear();
            }
        }

    }

    private Robot convertRowToData(Row row) {

        Robot robot = new Robot();

        Cell cell;
        int cellNum = 0;

        cell = row.getCell(cellNum++);
        String groupId = ExcelUtils.convertCellValueToString(cell);
        robot.setGroupId(groupId);

        cell = row.getCell(cellNum++);
        String product = ExcelUtils.convertCellValueToString(cell);
        robot.setProduct(product);

        cell = row.getCell(cellNum++);
        String comingPage = ExcelUtils.convertCellValueToString(cell);
        robot.setComingPage(comingPage);

        cell = row.getCell(cellNum++);
        String createTime = ExcelUtils.convertCellValueToString(cell);
        robot.setCreateTime(createTime);

        cell = row.getCell(cellNum++);
        String isScoreRobot = ExcelUtils.convertCellValueToString(cell);
        robot.setIsScoreRobot(isScoreRobot);

        cell = row.getCell(cellNum++);
        String robotIsSolve = ExcelUtils.convertCellValueToString(cell);
        robot.setRobotIsSolve(robotIsSolve);

        cell = row.getCell(cellNum++);
        String isArtificial = ExcelUtils.convertCellValueToString(cell);
        robot.setIsArtificial(isArtificial);

        cell = row.getCell(cellNum++);
        String artificialIsSolve = ExcelUtils.convertCellValueToString(cell);
        robot.setArtificialIsSolve(artificialIsSolve);

        cell = row.getCell(cellNum++);
        String artificialScore = ExcelUtils.convertCellValueToString(cell);
        robot.setArtificialScore(artificialScore);

        cell = row.getCell(cellNum++);
        String bid = ExcelUtils.convertCellValueToString(cell);
        robot.setBid(bid);

        cell = row.getCell(cellNum++);
        String userName = ExcelUtils.convertCellValueToString(cell);
        robot.setUserName(userName);

        cell = row.getCell(cellNum++);
        String serviceName = ExcelUtils.convertCellValueToString(cell);
        robot.setServiceName(serviceName);

        cell = row.getCell(cellNum++);
        String isWorkTime = ExcelUtils.convertCellValueToString(cell);
        robot.setIsWorkTime(isWorkTime);

        if (null == robot) {
            logger.warn("第 " + row.getRowNum() + "行数据不合法，已忽略！");
        }

        return null;
    }
}
