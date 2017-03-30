package com.aolei.spider.util;

/**
 * Created by Administrator on 2017/2/23.
 *
 * 返回类型定义，如果responseStatus
 */
public class ResponseStatus {
    public static final short SUCCESS = 1;//返回成功
    public static final short FAIL = 0;//有错误，或者异常，返回0
    private long responTime = System.currentTimeMillis();//当前的时间戳

    private short responseStaus = SUCCESS;//默认返回成功
    public short getResponseStaus() {
        return responseStaus;
    }

    public void setResponseStaus(short responseStaus) {
        this.responseStaus = responseStaus;
    }

    public long getResponTime() {
        return responTime;
    }

    public void setResponTime(long responTime) {
        this.responTime = responTime;
    }

    public ResponseStatus() {
    }

    public ResponseStatus(short responseStaus, long responTime) {
        this.responseStaus = responseStaus;
        this.responTime = responTime;
    }

    @Override
    public String toString() {
        return "ResponseStatus{" +
                "responseStaus=" + responseStaus +
                ", responTime=" + responTime +
                '}';
    }
}
