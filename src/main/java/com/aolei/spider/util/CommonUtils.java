package com.aolei.spider.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */
public class CommonUtils {
    public static Date stringToDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            System.out.println(simpleDateFormat.parse(date));
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String getElementValue(List<String> valueList,int index){
        return valueList.get(index);
    }
    public static  Date getElementDate(List<String> valueList,int index){
        return stringToDate(valueList.get(index));
    }
}
