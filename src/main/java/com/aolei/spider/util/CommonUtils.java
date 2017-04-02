package com.aolei.spider.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 * 通用工具类
 */
public class CommonUtils {
    /**
     * 将string类型的时间转换成Date类型的时间
     * @param date
     * @return
     */
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

    /**
     *
     * @param valueList
     * @param index
     * @return
     * 获取valueList中的对应的index的值
     */
    public static String getElementValue(List<String> valueList,int index){
        return valueList.get(index);
    }

    /**
     * 将valueList中获取的String类型的时间转换成Date类型的时间
     * @param valueList
     * @param index
     * @return
     */
    public static  Date getElementDate(List<String> valueList,int index){
        return stringToDate(valueList.get(index));
    }
}
