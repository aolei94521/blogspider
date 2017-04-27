package com.aolei.spider.controller;

import com.aolei.spider.service.ViewRecordService;
import com.aolei.spider.util.ReturnResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/4/18.
 */
@Controller
@RequestMapping("/record")
public class ViewRecordController extends BaseController{
    @Resource
    ViewRecordService viewRecordService;

    /**
     * 添加一条浏览记录
     * @param userName
     * @param blogId
     * @param tbName
     * @param response
     */
    @RequestMapping(value = "addRecord",method={RequestMethod.GET})
    public void addViewRecord(@RequestParam(value = "userName") String userName, @RequestParam(value = "blogId") int blogId, @RequestParam(value = "tbName") String tbName, HttpServletResponse response){
        int result = viewRecordService.addViewRecord(blogId,tbName,userName);
        if (result > 0){
            ReturnResultUtils.outWriteSuccess(response,"操作成功","[]");
        }else{
            ReturnResultUtils.outWriteUnSuccess(response,"操作失败","[]");
        }
    }

    /**
     * 删除一条浏览记录
     * @param recordId
     * @param response
     */
    @RequestMapping(value = "deleteReocrd",method = {RequestMethod.GET})
    public void deleteViewRecord(@RequestParam(value="recordId") int recordId,HttpServletResponse response){
        int result = viewRecordService.deleteViewRecord(recordId);
        if (result > 0){
            ReturnResultUtils.outWriteSuccess(response,"删除成功","[]");
        }else{
            ReturnResultUtils.outWriteUnSuccess(response,"删除失败","[]");
        }
    }

    /**
     * 删除所有浏览记录
     * @param userName
     * @param response
     */
    @RequestMapping(value = "deleteAll",method = {RequestMethod.GET})
    public void deleteAllRecord(@RequestParam(value="userName") String userName,HttpServletResponse response){
        int result = viewRecordService.deleteAllViewReocrd(userName);
        if (result > 0){
            ReturnResultUtils.outWriteSuccess(response,"删除成功","[]");
        }else{
            ReturnResultUtils.outWriteUnSuccess(response,"删除失败","[]");
        }
    }

}
