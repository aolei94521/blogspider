package com.aolei.spider.dao;

import com.aolei.spider.entity.viewRecordEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface viewRecordEntityMapper {
    @Delete({
        "delete from tb_view_record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_view_record (id, userId, ",
        "recordId, tbName, ",
        "viewTime)",
        "values (#{id,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
        "#{recordid,jdbcType=INTEGER}, #{tbname,jdbcType=VARCHAR}, ",
        "#{viewtime,jdbcType=TIMESTAMP})"
    })
    int insert(viewRecordEntity record);

    int insertSelective(viewRecordEntity record);

    @Select({
        "select",
        "id, userId, recordId, tbName, viewTime",
        "from tb_view_record",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    viewRecordEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(viewRecordEntity record);

    @Update({
        "update tb_view_record",
        "set userId = #{userid,jdbcType=INTEGER},",
          "recordId = #{recordid,jdbcType=INTEGER},",
          "tbName = #{tbname,jdbcType=VARCHAR},",
          "viewTime = #{viewtime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(viewRecordEntity record);
}