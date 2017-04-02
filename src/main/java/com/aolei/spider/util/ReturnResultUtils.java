package com.aolei.spider.util;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/2/23.
 */
public class ReturnResultUtils {
    private static final Logger logger = LoggerFactory.getLogger(ReturnResultUtils.class);

    /**
     *将用户请求到的数据进行封装
     * @param response
     * @param result
     * @return
     */
    public static PrintWriter outWriteResult(HttpServletResponse response, Object ...result){
        PrintWriter outWriter = null;
        try {
            response.setContentType("application/json;charset=UTF-8");
            outWriter = response.getWriter();
            outWriter.write(getResultJsonFormate(result));
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

    /**
     * 将用户请求到的数据封装成统一的返回格式
     * @param resultString
     * @return json字符串
     */
    private static String getResultJsonFormate(Object ... resultString){
        JSONResultUtils jsonResultUtils = new JSONResultUtils();
        //判断是否带有错误信息,如果不为空或者不是""则带有错误信息
        if (resultString.length >= 2 && (resultString[1] != null || !"".equals(resultString[1]))){
            jsonResultUtils.setMsg((String)resultString[1]);
            jsonResultUtils.setStatus(0);
            jsonResultUtils.setObj("");
            return JSON.toJSONString(jsonResultUtils);
        }

        jsonResultUtils.setObj(resultString[0]);
        jsonResultUtils.setStatus(1);
        jsonResultUtils.setMsg("");
        return  JSON.toJSONString(jsonResultUtils);
    }

}
