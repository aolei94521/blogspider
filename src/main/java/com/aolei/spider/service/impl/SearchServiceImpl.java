package com.aolei.spider.service.impl;

import com.aolei.spider.dao.SearchRecordEntityMapper;
import com.aolei.spider.entity.SearchRecordEntity;
import com.aolei.spider.service.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Administrator on 2017/5/14.
 */
@Service("SearchService")
public class SearchServiceImpl extends BaseService implements SearchService{
    @Resource
    private TuiKuService tuiKuService;
    @Resource
    private JueJinService jueJinService;
    @Resource
    private CNBlogService cnBlogService;
    @Resource
    private CSDNService csdnService;
    @Resource
    private CodeCeoService codeCeoService;
    @Resource
    private SearchRecordEntityMapper mapper;
    public List<?> search(int start, int count, String word, String tbName) {
        Map<String,Object> params = new HashMap<String,Object>();
        List<?> resultList = new ArrayList();
        if (count < 0 || count > 20){
            count = 20;
        }
        params.put("start",start);
        params.put("count",count);
        params.put("key",word);
        if ("tb_tuiku".equals(tbName)){
            resultList = tuiKuService.search(params);
        }else if ("tb_cnblogs_geek".equals(tbName)){
            resultList = csdnService.search(params);
        }else if("tb_juejin".equals(tbName)){
            resultList = jueJinService.search(params);
        }else if("tb_manong".equals(tbName)){
            resultList =codeCeoService.search(params);
        }else if("tb_cnblogs".equals(tbName)){
            resultList = codeCeoService.search(params);
        }
        return resultList;
    }

    public void addRecord(String userName, String word) {
        SearchRecordEntity recordEntity = new SearchRecordEntity();
        recordEntity.setCreatetime(new Date());
        recordEntity.setWord(word);
        recordEntity.setUsername(userName);
        mapper.insertSelective(recordEntity);
    }

    public List<SearchRecordEntity> getRecord(String userName) {
        return mapper.searchRecord(userName);
    }
}
