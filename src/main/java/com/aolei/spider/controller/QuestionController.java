package com.aolei.spider.controller;

import com.aolei.spider.entity.QuestionEntity;
import com.aolei.spider.service.QuestionService;
import com.aolei.spider.util.CommonStaticValue;
import com.aolei.spider.util.ReturnResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/4/22.
 */
@Controller
@RequestMapping("/question")
public class QuestionController extends BaseController{
    @Resource
    private QuestionService questionService;

    @RequestMapping(value = "addQuestion",method = {RequestMethod.GET})
    public void applyQuestioin(@RequestParam(value = "userName") String userName, @RequestParam(value = "title") String title, @RequestParam(value = "content") String content, HttpServletResponse response){
        questionService.applyQuestion(userName,title,content);
        ReturnResultUtils.outWriteResult(response,"[]","发布成功");
    }
    @RequestMapping(value = "deleteQuestion", method={RequestMethod.GET})
    public void deleteQuestion(@RequestParam(value = "id") int id,HttpServletResponse response){
        questionService.deleteQuestion(id);
        ReturnResultUtils.outWriteResult(response,"[]","删除成功");

    }
    @RequestMapping(value = "like",method = {RequestMethod.GET})
    public void likeQuestion(@RequestParam(value = "id") int id,@RequestParam(value = "likeStatus") int likeStatus,HttpServletResponse response){
        questionService.likeQuestion(id,likeStatus);
    }
    @RequestMapping(value = "allQuestion",method = {RequestMethod.GET})
    public void getAllQuesion(@RequestParam(value = "start") int start,@RequestParam(value = "count") int count,HttpServletResponse response){
        List<QuestionEntity> questionEntityList = questionService.getAllQuestion(start,count);
        if (questionEntityList != null && !questionEntityList.isEmpty()){
            int size = questionEntityList.size();
            int nextStart = questionEntityList.get(size - 1).getId();
            if (size < count){
                ReturnResultUtils.outWriteResultList(response, CommonStaticValue.NOMORE,nextStart,questionEntityList);
            }else{
                ReturnResultUtils.outWriteResultList(response, CommonStaticValue.HASMORE,nextStart,questionEntityList);
            }
        }else{
            ReturnResultUtils.outWriteResultList(response, CommonStaticValue.NOMORE,CommonStaticValue.NOSTART,"没有更多了");
        }
    }

    @RequestMapping("myQuestions")
    public void getMyQuestion(@RequestParam(value = "userName") String userName,HttpServletResponse response){
        List<QuestionEntity> questionEntities = questionService.getQuestionByName(userName);
        if (questionEntities != null && !questionEntities.isEmpty()){
            ReturnResultUtils.outWriteResult(response,questionEntities);
        }else{
            ReturnResultUtils.outWriteResult(response,questionEntities,"暂时没有发布问题");
        }
    }
    @RequestMapping("answer")
    public void answerQuestion(@RequestParam(value = "questionId") int questionId,@RequestParam(value = "userName")String userName,@RequestParam(value = "content",required = false)String content,@RequestParam(value = "replayUserName",required = false)String replayUserName,@RequestParam(value = "replayContent",required = false)String replayContent,HttpServletResponse response){
        questionService.answerQuestion(questionId,userName,content,replayUserName,replayUserName);
        ReturnResultUtils.outWriteResult(response,"[]","回复成功");
    }
    @RequestMapping("myAnswer")
    public void myAnswerQuestion(@RequestParam(value = "userName") String userName,HttpServletResponse response){
        List<QuestionEntity> questionEntities = questionService.getMyAnswerQuestion(userName);
        if (questionEntities != null && !questionEntities.isEmpty()){
            ReturnResultUtils.outWriteResultList(response,CommonStaticValue.NOMORE,CommonStaticValue.NOSTART,questionEntities);
        }else{
            ReturnResultUtils.outWriteResultList(response,CommonStaticValue.NOMORE,CommonStaticValue.NOSTART,questionEntities,"暂未回答问题");
        }
    }
}
