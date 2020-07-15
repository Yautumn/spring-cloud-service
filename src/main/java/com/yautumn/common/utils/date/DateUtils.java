package com.yautumn.common.utils.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String dateToString(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String str=sdf.format(date);
        return str;
    }

    public static String dateTimeToString(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        String str=sdf.format(date);
        return str;
    }
}
