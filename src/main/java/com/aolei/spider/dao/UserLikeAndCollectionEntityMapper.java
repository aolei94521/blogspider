package com.aolei.spider.dao;

import com.aolei.spider.entity.UserLikeAndCollectionEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserLikeAndCollectionEntityMapper {
    @Delete({
        "delete from tb_user_like_and_collection",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_user_like_and_collection (id, userName, ",
        "type, createTime`, ",
        "status, tbName, ",
        "blogId)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=INTEGER}, #{createtime`,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=INTEGER}, #{tbname,jdbcType=VARCHAR}, ",
        "#{blogid,jdbcType=LONGVARCHAR})"
    })
    int insert(UserLikeAndCollectionEntity record);

    int insertSelective(UserLikeAndCollectionEntity record);

    @Select({
        "select",
        "id, userName, type, createTime`, status, tbName, blogId",
        "from tb_user_like_and_collection",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("ResultMapWithBLOBs")
    UserLikeAndCollectionEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserLikeAndCollectionEntity record);

    @Update({
        "update tb_user_like_and_collection",
        "set userName = #{username,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER},",
          "createTime` = #{createtime`,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "tbName = #{tbname,jdbcType=VARCHAR},",
          "blogId = #{blogid,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(UserLikeAndCollectionEntity record);

    @Update({
        "update tb_user_like_and_collection",
        "set userName = #{username,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER},",
          "createTime` = #{createtime`,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "tbName = #{tbname,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserLikeAndCollectionEntity record);
}