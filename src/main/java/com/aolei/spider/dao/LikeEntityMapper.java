package com.aolei.spider.dao;

import com.aolei.spider.entity.LikeEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface LikeEntityMapper {
    @Delete({
        "delete from tb_like",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_like (id, blogId, ",
        "tbName, likeCount, ",
        "createTime)",
        "values (#{id,jdbcType=INTEGER}, #{blogid,jdbcType=INTEGER}, ",
        "#{tbname,jdbcType=VARCHAR}, #{likecount,jdbcType=INTEGER}, ",
        "#{createtime,jdbcType=TIMESTAMP})"
    })
    int insert(LikeEntity record);

    int insertSelective(LikeEntity record);

    @Select({
        "select",
        "id, blogId, tbName, likeCount, createTime",
        "from tb_like",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    LikeEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LikeEntity record);

    @Update({
        "update tb_like",
        "set blogId = #{blogid,jdbcType=INTEGER},",
          "tbName = #{tbname,jdbcType=VARCHAR},",
          "likeCount = #{likecount,jdbcType=INTEGER},",
          "createTime = #{createtime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(LikeEntity record);
}