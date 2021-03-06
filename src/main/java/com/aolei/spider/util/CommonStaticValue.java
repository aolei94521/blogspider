package com.aolei.spider.util;

/**
 * Created by Administrator on 2017/3/29.
 */
public class CommonStaticValue {
    public static final int SLEEPTIME = 1000;//睡眠时间 1D
    public static final int RETRYTIME = 1000 * 3;//重试时间 3S
    public static final String CHARSET = "UTF-8";//字符编码
    public static final int THREAD_COUNT = 50;//开启爬数据爬虫的线程的数量
    public static final int COMMONDATATYPE = 0; //通用数据格式
    public static final int TUIKUDATATYPE= 1; //推库专用数据格式
    public static final int HASMORE = 1;//数据分页有下一页
    public static final int NOMORE = 0;//数据分页没有下一页
    public static final int NOSTART = -1;//当查询的分页数据为空时，使用
    public static final int ERRORSTATUS = 1;
    public static final int LIKE = 2;//点赞
    public static final int COLLECTION = 1;//收藏
    public static final int LIKESTATUS = 1;//点赞或收藏状态
    public static final int DISLIKESTATUS = 2;//取消点赞或收藏
    public static final int NORMAL = 1;//问题有效
    public static final int UNNORMAL = 2;//问题无效
    public static final int CONLLECTIONORLIKE=1;//收藏或者点赞
}
