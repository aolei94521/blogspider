package com.aolei.spider.util;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/2/23.
 */
public class ReturnResultUtils {


    public static PrintWriter outWriteResult(HttpServletResponse response, Object result){
        PrintWriter outWriter = null;
        try {
            response.setContentType("application/json;charset=UTF-8");
            outWriter = response.getWriter();
            outWriter.write(JSON.toJSONString(result));
            return response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (outWriter != null){
                outWriter.close();
            }
        }
        return outWriter;
    }


}
