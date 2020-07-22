package com.yautumn.service.loss;

import java.io.File;

public interface LossService {
    void readExcel(String fileName);

    File writeExcel();
}
