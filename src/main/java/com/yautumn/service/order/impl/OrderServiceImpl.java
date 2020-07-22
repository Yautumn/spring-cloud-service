package com.yautumn.service.order.impl;

import com.yautumn.common.entity.Order;
import com.yautumn.common.reflect.BaseService;
import com.yautumn.common.utils.date.DateUtils;
import com.yautumn.common.utils.poi.ExcelUtils;
import com.yautumn.dao.order.OrderMapper;
import com.yautumn.service.order.OrderService;
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
public class OrderServiceImpl  extends BaseService implements OrderService {
    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public void readExcel(String fileName) {
        List<Row> rowList = ExcelUtils.readExcel(fileName);
        List<Order> orderList = new ArrayList<>();

        rowList.forEach(row -> orderList.add(convertRowToData(row)));

        if (!orderList.isEmpty() || orderList.size() != 0){
            super.batch(orderList,OrderMapper.class,"insertForeach");
        }
    }

    private Order convertRowToData(Row row) {
        Order order = new Order();
        Cell cell;
        int cellNum = 0;

        cell = row.getCell(cellNum++);
        String orderId = ExcelUtils.convertCellValueToString(cell);
        order.setOrderId(orderId);

        cell = row.getCell(cellNum++);
        String contacts = ExcelUtils.convertCellValueToString(cell);
        order.setContacts(contacts);

        cell = row.getCell(cellNum++);
        String province = ExcelUtils.convertCellValueToString(cell);
        order.setProvince(province);

        cell = row.getCell(cellNum++);
        String city = ExcelUtils.convertCellValueToString(cell);
        order.setCity(city);

        cell = row.getCell(cellNum++);
        String consumerName = ExcelUtils.convertCellValueToString(cell);
        order.setConsumerName(consumerName);

        cell = row.getCell(cellNum++);
        String did = ExcelUtils.convertCellValueToString(cell);
        order.setDid(did);

        cell = row.getCell(cellNum++);
        String walletId = ExcelUtils.convertCellValueToString(cell);
        order.setWalletId(walletId);

        cell = row.getCell(cellNum++);
        String telNum = ExcelUtils.convertCellValueToString(cell);
        order.setTelNum(telNum);

        cell = row.getCell(cellNum++);
        String productLine = ExcelUtils.convertCellValueToString(cell);
        order.setProductLine(productLine);

        cell = row.getCell(cellNum++);
        String event1 = ExcelUtils.convertCellValueToString(cell);
        order.setEvent1(event1);

        cell = row.getCell(cellNum++);
        String event2 = ExcelUtils.convertCellValueToString(cell);
        order.setEvent2(event2);

        cell = row.getCell(cellNum++);
        String event3 = ExcelUtils.convertCellValueToString(cell);
        order.setEvent3(event3);

        cell = row.getCell(cellNum++);
        String event4 = ExcelUtils.convertCellValueToString(cell);
        order.setEvent4(event4);

        cell = row.getCell(cellNum++);
        String event5 = ExcelUtils.convertCellValueToString(cell);
        order.setEvent5(event5);

        cell = row.getCell(cellNum++);
        String priority = ExcelUtils.convertCellValueToString(cell);
        order.setPriority(priority);

        cell = row.getCell(cellNum++);
        String urgeTimes = ExcelUtils.convertCellValueToString(cell);
        order.setUrgeTimes(urgeTimes);

        cell = row.getCell(cellNum++);
        String urgeCause = ExcelUtils.convertCellValueToString(cell);
        order.setUrgeCause(urgeCause);

        cell = row.getCell(cellNum++);
        String tradeMerchants = ExcelUtils.convertCellValueToString(cell);
        order.setTradeMerchants(tradeMerchants);

        cell = row.getCell(cellNum++);
        String sourceChannel = ExcelUtils.convertCellValueToString(cell);
        order.setSourceChannel(sourceChannel);

        cell = row.getCell(cellNum++);
        String commType = ExcelUtils.convertCellValueToString(cell);
        order.setCommType(commType);

        cell = row.getCell(cellNum++);
        String orderStatus = ExcelUtils.convertCellValueToString(cell);
        order.setOrderStatus(orderStatus);

        cell = row.getCell(cellNum++);
        String creatJob = ExcelUtils.convertCellValueToString(cell);
        order.setCreatJob(creatJob);

        cell = row.getCell(cellNum++);
        String acceptJob = ExcelUtils.convertCellValueToString(cell);
        order.setAcceptJob(acceptJob);

        cell = row.getCell(cellNum++);
        String acceptor = ExcelUtils.convertCellValueToString(cell);
        order.setAcceptor(acceptor);

        cell = row.getCell(cellNum++);
        String isNeedCallback = ExcelUtils.convertCellValueToString(cell);
        order.setIsNeedCallback(isNeedCallback);

        cell = row.getCell(cellNum++);
        String callbackNum = ExcelUtils.convertCellValueToString(cell);
        order.setCallbackNum(callbackNum);

        cell = row.getCell(cellNum++);
        String commTimes = ExcelUtils.convertCellValueToString(cell);
        order.setCommTimes(commTimes);

        cell = row.getCell(cellNum++);
        String quesstionDesc = ExcelUtils.convertCellValueToString(cell);
        order.setQuesstionDesc(quesstionDesc);

        cell = row.getCell(cellNum++);
        String resolve = ExcelUtils.convertCellValueToString(cell);
        order.setResolve(resolve);

        cell = row.getCell(cellNum++);
        String isMessage = ExcelUtils.convertCellValueToString(cell);
        order.setIsMessage(isMessage);

        cell = row.getCell(cellNum++);
        String isForward = ExcelUtils.convertCellValueToString(cell);
        order.setIsForward(isForward);

        cell = row.getCell(cellNum++);
        String satisfaction = ExcelUtils.convertCellValueToString(cell);
        order.setSatisfaction(satisfaction);

        cell = row.getCell(cellNum++);
        String isResolve = ExcelUtils.convertCellValueToString(cell);
        order.setIsResolve(isResolve);

        cell = row.getCell(cellNum++);
        String creater = ExcelUtils.convertCellValueToString(cell);
        order.setCreater(creater);

        cell = row.getCell(cellNum++);
        String createTimeStr = cell.getStringCellValue();
//        Date createDate = cell.getDateCellValue();
//        String createTime = DateUtils.dateTimeToString(createDate);
        order.setCreateTime(createTimeStr);

        cell = row.getCell(cellNum++);
//        Date updateDate = cell.getDateCellValue();
//        String updateTime = DateUtils.dateTimeToString(updateDate);
        String updateTimeStr = cell.getStringCellValue();
        order.setUpdateTime(updateTimeStr);

        cell = row.getCell(cellNum++);
//        Date endDate = cell.getDateCellValue();
//        String endTime = DateUtils.dateTimeToString(endDate);
        String endTimeStr = cell.getStringCellValue();
        order.setEndTime(endTimeStr);

        cell = row.getCell(cellNum++);
        String bankName = ExcelUtils.convertCellValueToString(cell);
        order.setBankName(bankName);

        cell = row.getCell(cellNum++);
        String payWay = ExcelUtils.convertCellValueToString(cell);
        order.setPayWay(payWay);

        cell = row.getCell(cellNum++);
        String safeCardStatus = ExcelUtils.convertCellValueToString(cell);
        order.setSafeCardStatus(safeCardStatus);

        cell = row.getCell(cellNum++);
        String newCardBinding = ExcelUtils.convertCellValueToString(cell);
        order.setNewCardBinding(newCardBinding);

        cell = row.getCell(cellNum++);
        String newCardSubscribe = ExcelUtils.convertCellValueToString(cell);
        order.setNewCardSubscribe(newCardSubscribe);

        cell = row.getCell(cellNum++);
        String errorMsg = ExcelUtils.convertCellValueToString(cell);
        order.setErrorMsg(errorMsg);

        cell = row.getCell(cellNum++);
        String operatingTerminal = ExcelUtils.convertCellValueToString(cell);
        order.setOperatingTerminal(operatingTerminal);

        cell = row.getCell(cellNum++);
        String activeName = ExcelUtils.convertCellValueToString(cell);
        order.setActiveName(activeName);

        cell = row.getCell(cellNum++);
        String isCalled = ExcelUtils.convertCellValueToString(cell);
        order.setIsCalled(isCalled);

        cell = row.getCell(cellNum++);
        String isEmail = ExcelUtils.convertCellValueToString(cell);
        order.setIsEmail(isEmail);

        cell = row.getCell(cellNum++);
        String email = ExcelUtils.convertCellValueToString(cell);
        order.setEmail(email);

        cell = row.getCell(cellNum++);
        String level = ExcelUtils.convertCellValueToString(cell);
        order.setLevel(level);

        if (null == order) {
            logger.warn("第 " + row.getRowNum() + "行数据不合法，已忽略！");
        }

        return order;
    }
}
