package com.aolei.spider.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 * 通用工具类
 */
public class CommonUtils extends CommonLoggerUtil{
    private static final String REQUSTURLSUFFIX = "?lang=1";
    private static Logger logger = LoggerFactory.getLogger(CommonUtils.class);
    /**
     * 将string类型的时间转换成Date类型的时间
     * @param date
     * @return
     */
    public static Date stringToDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    public static Date StringToDateForTuiKu(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm");
        try{
            return simpleDateFormat.parse(date);
        }catch (ParseException e){
            logger.error(e.getMessage());
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
     * @Param type
     * @return
     */
    public static  Date getElementDate(List<String> valueList,int index,int type){
        Date date = null;
        switch (type){
            case CommonStaticValue.COMMONDATATYPE:
                date = stringToDate(valueList.get(index));
                break;
            case CommonStaticValue.TUIKUDATATYPE:
                date = StringToDateForTuiKu(valueList.get(index));
                break;
            default:
                break;
        }
        return date;
    }

    /**
     * 拼接推酷网请求数据的Url
     * @return 请求数据Url List集合
     */
    public static List<String> getRequestTargetUrls(){
        List<String> requestTargetUrlsList = new ArrayList<String>();
        for (int pageIndxe = 1; pageIndxe <= 20; pageIndxe++){
                requestTargetUrlsList.add(pageIndxe + REQUSTURLSUFFIX);
        }
        return requestTargetUrlsList;
    }

    public static <T>  boolean listIsEmputyOrNull(List<T> list){
        boolean listIsEmputyOrNull = false;
        if (list == null || list.isEmpty()){
            listIsEmputyOrNull = true;
        }
        return listIsEmputyOrNull;
    }
}
