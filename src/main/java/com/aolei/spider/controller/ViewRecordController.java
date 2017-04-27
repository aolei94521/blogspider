package com.aolei.spider.controller;

import com.aolei.spider.entity.ViewBlogEntity;
import com.aolei.spider.service.ViewRecordService;
import com.aolei.spider.util.ReturnResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    public void deleteViewRecord(@RequestParam(value="recordId") int recordId,@RequestParam(value="userName") String userName,HttpServletResponse response){
        int result = 0;
        if (recordId == -1){
            viewRecordService.deleteAllViewReocrd(userName);
        }else{
            viewRecordService.deleteViewRecord(recordId,userName);
        }
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
    @RequestMapping(value = "allRecord",method = {RequestMethod.GET})
    public void getAllRecord(@RequestParam(value="userName") String userName,HttpServletResponse response){
        List<ViewBlogEntity> viewBlogEntities = viewRecordService.getAllViewRecord(userName);
        if (viewBlogEntities != null && !viewBlogEntities.isEmpty()){
            ReturnResultUtils.outWriteSuccess(response,"",viewBlogEntities);
        }else{
            ReturnResultUtils.outWriteUnSuccess(response,"暂无记录","[]");
        }
    }



}
