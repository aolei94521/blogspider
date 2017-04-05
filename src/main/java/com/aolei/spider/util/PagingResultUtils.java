package com.aolei.spider.util;

/**
 * Created by Administrator on 2017/4/5.
 */
public class PagingResultUtils extends JSONResultUtils{
    private int start;
    private int more;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getMore() {
        return more;
    }

    public void setMore(int more) {
        this.more = more;
    }

    @Override
    public String toString() {
        return "PagingResultUtils{" +
                "start=" + start +
                ", more=" + more +
                '}';
    }
}
