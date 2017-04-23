package com.aolei.spider.controller;

import com.aolei.spider.entity.CommentEntity;
import com.aolei.spider.service.BlogCommentService;
import com.aolei.spider.service.UserBlogLikeAndCollectionService;
import com.aolei.spider.util.CommonStaticValue;
import com.aolei.spider.util.CommonUtils;
import com.aolei.spider.util.ReturnResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/4/16.
 */
@Controller
@RequestMapping("/blog")
public class UserBlogLikeAndCollectController extends BaseController{
    @Resource
    private UserBlogLikeAndCollectionService blogLikeService;
    @Resource
    private BlogCommentService blogCommentService;
    /**
     * 点赞或收藏，或取消点赞，取消收藏
     * @param userName
     * @param blogId
     * @param type
     * @param status
     * @param tbName
     * @param response
     */
    @RequestMapping(value = "like",method={RequestMethod.GET})
    public void bolgLike(@RequestParam(value="userName",required = true) String userName, @RequestParam(value="blogId",required = true) int blogId, @RequestParam(value="type",required = true) int type, @RequestParam(value="status",required = true) int status, @RequestParam(value="tbName",required = true) String tbName, HttpServletResponse response){
        int result = blogLikeService.blogLike(userName,blogId,type,status,tbName);
        if (result > 0){
            ReturnResultUtils.outWriteResult(response,"[]","操作成功");
        }else{
            ReturnResultUtils.outWriteResult(response,"[]","操作失败");
        }
    }

    /**
     * 博客评论
     * @param blogId
     * @param content
     * @param userName
     * @param tbName
     * @param replayUserName
     * @param replayContent
     * @param response
     */
    @RequestMapping(value = "comment",method={RequestMethod.GET})
    public void blogComment(@RequestParam(value = "blogId")int blogId,@RequestParam(value = "content")String content,@RequestParam(value = "userName")String userName,@RequestParam(value = "tbName")String tbName,@RequestParam(value = "replayUserName",required = false)String replayUserName,@RequestParam(value = "replayContent",required = false)String replayContent,HttpServletResponse response){
        int result = 0;
        if ((replayContent == null || replayContent.length() <= 0) && (replayUserName == null || replayUserName.length() <= 0)){
             result = blogCommentService.blogComment(tbName,userName,content,blogId);
        }else{
             result = blogCommentService.blogReplay(tbName,userName,content,replayUserName,replayContent,blogId);
        }
        if (result > 0){
            ReturnResultUtils.outWriteResult(response,"[]","评论成功");
        }else{
            ReturnResultUtils.outWriteResult(response,"[]","评论失败");
        }
    }
    @RequestMapping(value = "getComments",method = {RequestMethod.GET})
    public void commentList(@RequestParam(value = "blogId") int blogId,@RequestParam(value = "tbName") String tbName,@RequestParam(value = "start") int start,@RequestParam(value = "count") int count,HttpServletResponse response){
        List<CommentEntity> commentEntityList = blogCommentService.getCommentList(blogId,tbName,start,count);
        if (!CommonUtils.listIsEmputyOrNull(commentEntityList)){
            logger.info("=================="+commentEntityList.size());
            int size = commentEntityList.size();
            int nextStart = commentEntityList.get(size - 1).getId();
            if (size > count){
                ReturnResultUtils.outWriteResultList(response, CommonStaticValue.HASMORE,nextStart,commentEntityList);
            }else{
                ReturnResultUtils.outWriteResultList(response,CommonStaticValue.NOMORE,nextStart,commentEntityList);
            }
        }else{
            ReturnResultUtils.outWriteResultList(response,CommonStaticValue.NOMORE,CommonStaticValue.NOSTART,commentEntityList,"暂无评论");
        }
    }
}
