package com.aolei.spider.controller;

import com.aolei.spider.entity.AnswerEntity;
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

    /**
     * 发布问题
     * @param userName
     * @param title
     * @param content
     * @param response
     */
    @RequestMapping(value = "addQuestion",method = {RequestMethod.GET})
    public void applyQuestioin(@RequestParam(value = "userName") String userName, @RequestParam(value = "title") String title, @RequestParam(value = "content") String content, HttpServletResponse response){
        questionService.applyQuestion(userName,title,content);
        ReturnResultUtils.outWriteSuccess(response,"发布成功","[]");
    }

    /**
     * 删除问题
     * @param id
     * @param response
     */
    @RequestMapping(value = "deleteQuestion", method={RequestMethod.GET})
    public void deleteQuestion(@RequestParam(value = "id") int id,HttpServletResponse response){
        questionService.deleteQuestion(id);
        ReturnResultUtils.outWriteSuccess(response,"删除成功","[]");

    }

    /**
     * 点赞
     * @param id
     * @param likeStatus
     * @param response
     */
    @RequestMapping(value = "like",method = {RequestMethod.GET})
    public void likeQuestion(@RequestParam(value = "id") int id,@RequestParam(value = "likeStatus") int likeStatus,HttpServletResponse response){
        questionService.likeQuestion(id,likeStatus);
        ReturnResultUtils.outWriteSuccess(response,"操作成功","[]");
    }
    @RequestMapping(value = "allQuestion",method = {RequestMethod.GET})
    public void getAllQuesion(@RequestParam(value = "start") int start,@RequestParam(value = "count") int count,HttpServletResponse response){
        List<QuestionEntity> questionEntityList = questionService.getAllQuestion(start,count);
        if (questionEntityList != null && !questionEntityList.isEmpty()){
            int size = questionEntityList.size();
            int nextStart = questionEntityList.get(size - 1).getId();
            if (size < count){
                ReturnResultUtils.outWriteSuccessList(response, CommonStaticValue.NOMORE,nextStart,"",questionEntityList);
            }else{
                ReturnResultUtils.outWriteSuccessList(response, CommonStaticValue.HASMORE,nextStart,"没有更多了",questionEntityList);
            }
        }else{
            ReturnResultUtils.outWriteUnSuccessList(response, CommonStaticValue.NOMORE,CommonStaticValue.NOSTART,"暂无问题，发布一个吧",questionEntityList);
        }
    }

    /**
     * 我发布的问题
     * @param userName
     * @param response
     */
    @RequestMapping("myQuestions")
    public void getMyQuestion(@RequestParam(value = "userName") String userName,HttpServletResponse response){
        List<QuestionEntity> questionEntities = questionService.getQuestionByName(userName);
        if (questionEntities != null && !questionEntities.isEmpty()){
            ReturnResultUtils.outWriteSuccess(response,"",questionEntities);
        }else{
            ReturnResultUtils.outWriteSuccess(response,"暂时没有发布问题,去发布一个吧",questionEntities);
        }
    }

    /**
     * 回答问题
     * @param questionId
     * @param userName
     * @param content
     * @param replayUserName
     * @param replayContent
     * @param response
     */
    @RequestMapping("answer")
    public void answerQuestion(@RequestParam(value = "questionId") int questionId,@RequestParam(value = "userName")String userName,@RequestParam(value = "content",required = false)String content,@RequestParam(value = "replayUserName",required = false)String replayUserName,@RequestParam(value = "replayContent",required = false)String replayContent,HttpServletResponse response){

        questionService.answerQuestion(questionId,userName,content,replayUserName,replayContent);
        ReturnResultUtils.outWriteSuccess(response,"回复成功","[]");
    }

    /**
     * 获取我回答过的问题列表，
     * @param userName
     * @param response
     */
    @RequestMapping("myAnswer")
    public void myAnswerQuestion(@RequestParam(value = "userName") String userName,HttpServletResponse response){
        List<QuestionEntity> questionEntities = questionService.getMyAnswerQuestion(userName);
        if (questionEntities != null && !questionEntities.isEmpty()){
            ReturnResultUtils.outWriteSuccessList(response,CommonStaticValue.NOMORE,CommonStaticValue.NOSTART,"",questionEntities);
        }else{
            ReturnResultUtils.outWriteUnSuccessList(response,CommonStaticValue.NOMORE,CommonStaticValue.NOSTART,"暂未回答问题",questionEntities);
        }
    }

    /**
     * 获取答案列表
     * @param questionId
     * @param response
     */
    @RequestMapping("getAnswer")
    public void getAnswers(@RequestParam(value = "questionId") int questionId,HttpServletResponse response){
        List<AnswerEntity> answerEntities = questionService.getAnswer(questionId);
        if (answerEntities != null && !answerEntities.isEmpty()){
            ReturnResultUtils.outWriteSuccess(response,"",answerEntities);
        }else{
            ReturnResultUtils.outWriteSuccess(response,"暂无回答,去回答一下吧",answerEntities);
        }
    }
}
