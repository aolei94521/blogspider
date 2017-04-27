package com.aolei.spider.service.impl;

import com.aolei.spider.dao.*;
import com.aolei.spider.entity.*;
import com.aolei.spider.service.BaseService;
import com.aolei.spider.service.ViewRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */
@Service("ViewRecordService")
public class ViewRecordServiceImpl extends BaseService implements ViewRecordService{
    @Resource
    @Autowired
    ViewRecordEntityMapper viewRecordEntityMapper;
    @Resource
    @Autowired
    CodeCeoEntityMapper codeCeoEntityMapper;
    @Resource
    @Autowired
    CNBlogsEntityMapper cnBlogsEntityMapper;
    @Resource
    @Autowired
    CSDNEntityMapper csdnEntityMapper;
    @Resource
    @Autowired
    JueJinEntityMapper jueJinEntityMapper;
    @Resource
    @Autowired
    TuiKuEntityMapper tuiKuEntityMapper;
    @Resource
    @Autowired
    ViewBlogEntityMapper viewBlogEntityMapper;
    public int addViewRecord(int blogId, String tbName, String userName) {
        ViewBlogEntity viewBlogEntity = new ViewBlogEntity();
        viewBlogEntity.setUserName(userName);
        viewBlogEntity.setViewTime(new Date());
        ViewRecordEntity viewRecordEntity = new ViewRecordEntity();
        viewRecordEntity.setBlogid(blogId);
        viewRecordEntity.setTbname(tbName);
        viewRecordEntity.setUsername(userName);
        viewRecordEntity.setViewtime(new Date());
        if ("tb_tuiku".equals(tbName)){
            TuiKuEntity tuiKuEntity = tuiKuEntityMapper.selectById(blogId);
            if (tuiKuEntity != null){
                viewBlogEntity.setTitle(tuiKuEntity.getTitle());
                viewBlogEntity.setAuthor(tuiKuEntity.getAuther());
                viewBlogEntity.setImagelink(tuiKuEntity.getImgurl());
                viewBlogEntity.setTime(tuiKuEntity.getTime());
                viewBlogEntity.setBlogid(tuiKuEntity.getId());
                viewBlogEntity.setLink(tuiKuEntity.getUrl());
                viewBlogEntity.setTbname(tuiKuEntity.getTbName());

            }
        }else if ("tb_manong".equals(tbName)){
            CodeCeoEntity codeCeoEntity = codeCeoEntityMapper.selectById(blogId);
            if (codeCeoEntity != null){
                viewBlogEntity.setTitle(codeCeoEntity.getTitle());
                viewBlogEntity.setContent(codeCeoEntity.getContent());
                viewBlogEntity.setImagelink(codeCeoEntity.getImagelink());
                viewBlogEntity.setBlogid(codeCeoEntity.getId());
                viewBlogEntity.setTbname(codeCeoEntity.getTbName());
            }
        }else if ("tb_juejin".equals(tbName)){
            JueJinEntity jueJinEntity = jueJinEntityMapper.selectById(blogId);
            if (jueJinEntity != null){
                viewBlogEntity.setTitle(jueJinEntity.getTitle());
                viewBlogEntity.setAuthor(jueJinEntity.getAuthor());
                viewBlogEntity.setLink(jueJinEntity.getLink());
                viewBlogEntity.setBlogid(jueJinEntity.getId());
                viewBlogEntity.setImagelink(jueJinEntity.getImagelink());
                viewBlogEntity.setTbname(jueJinEntity.getTbName());
            }
        }else if ("tb_cnblogs_geek".equals(tbName)){
            CSDNEntity csdnEntity = csdnEntityMapper.selectById(blogId);
            if (csdnEntity != null){
                viewBlogEntity.setTitle(csdnEntity.getTitle());
                viewBlogEntity.setLink(csdnEntity.getUrl());
                viewBlogEntity.setImagelink(csdnEntity.getImagelink());
                viewBlogEntity.setBlogid(csdnEntity.getId());
                viewBlogEntity.setTime(csdnEntity.getTime());
                viewBlogEntity.setTbname(csdnEntity.getTbName());
            }
        }else if ("tb_cnblogs".equals(tbName)){
            CNBlogsEntity cnBlogsEntity = cnBlogsEntityMapper.selectById(blogId);
            if (cnBlogsEntity != null){
                viewBlogEntity.setTitle(cnBlogsEntity.getTitle());
                viewBlogEntity.setAuthor(cnBlogsEntity.getAuthor());
                viewBlogEntity.setLink(cnBlogsEntity.getLink());
                viewBlogEntity.setBlogid(cnBlogsEntity.getId());
                viewBlogEntity.setContent(cnBlogsEntity.getContent());
                viewBlogEntity.setTbname(cnBlogsEntity.getTbName());
            }
        }
        return viewBlogEntityMapper.insertSelective(viewBlogEntity);
    }

    public int deleteViewRecord(int recordId,String userName) {
        return viewBlogEntityMapper.deleteByRecordId(recordId,userName);
    }

    public int deleteAllViewReocrd(String userName) {
        return viewBlogEntityMapper.deleteByUserName(userName);
    }

    public List<ViewBlogEntity> getAllViewRecord(String userName) {
        return viewBlogEntityMapper.getAllRecord(userName);
    }

}