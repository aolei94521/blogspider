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

    public static PrintWriter outWriteResultForRegist(HttpServletResponse response,String msg){
        JSONResultUtils jsonResultUtils = new JSONResultUtils();
        String result = null;
        PrintWriter outWriter = null;
        try {
            response.setContentType("application/json;charset=UTF-8");
            outWriter = response.getWriter();
            if (msg.equals("注册成功")){
                jsonResultUtils.setMsg(msg);
                result = JSON.toJSONString(jsonResultUtils);
            }else{
                jsonResultUtils.setMsg(msg);
                jsonResultUtils.setStatus(CommonStaticValue.ERRORSTATUS);
                result = JSON.toJSONString(jsonResultUtils);
            }
            outWriter.write(result);
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
     * 将用户请求到的数据进行封装,数据分页专用，
     * @param response
     * @param more 是否有下一页
     * @param start 下一次请求数据的开始索引
     * @param result
     * @return
     */
    public static PrintWriter outWriteResultList(HttpServletResponse response, int more,int start,Object ...result){
        PrintWriter outWriter = null;
        try {
            response.setContentType("application/json;charset=UTF-8");
            outWriter = response.getWriter();
            outWriter.write(getResultJsonFormate(more,start,result));
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
    private static String   getResultJsonFormate(Object ... resultString){
        JSONResultUtils jsonResultUtils = new JSONResultUtils();
        //判断是否带有错误信息,如果不为空或者不是""则带有错误信息
        if (resultString.length >= 2 && (resultString[1] != null || !"".equals(resultString[1]))){
            jsonResultUtils.setMsg((String)resultString[1]);
            jsonResultUtils.setStatus(0);
            jsonResultUtils.setObj("[]");
            JSON.toJSONString(jsonResultUtils);
        }

        jsonResultUtils.setObj(resultString[0]);
        jsonResultUtils.setStatus(1);
        jsonResultUtils.setMsg("");
        logger.info("++++++"+JSON.toJSONString(jsonResultUtils));
        return  JSON.toJSONString(jsonResultUtils);
    }

    /**
     * 将用户请求到的数据封装成统一的返回格式 数据分页专用
     * @param more
     * @param start
     * @param resultString
     * @return
     */
    private static String getResultJsonFormate(int more,int start,Object ... resultString){
        PagingResultUtils pagingResultUtils = new PagingResultUtils();
        //判断是否带有错误信息,如果不为空或者不是""则带有错误信息
        if (resultString.length >= 2 && (resultString[1] != null || !"".equals(resultString[1]))){
            pagingResultUtils.setMsg((String)resultString[1]);
            pagingResultUtils.setStatus(0);
            pagingResultUtils.setObj("[]");
            pagingResultUtils.setStart(start);
            pagingResultUtils.setMore(more);
            return JSON.toJSONString(pagingResultUtils);
        }

        pagingResultUtils.setObj(resultString[0]);
        pagingResultUtils.setStatus(1);
        pagingResultUtils.setMsg("");
        pagingResultUtils.setMore(more);
        pagingResultUtils.setStart(start);
        return  JSON.toJSONString(pagingResultUtils);
    }

}
