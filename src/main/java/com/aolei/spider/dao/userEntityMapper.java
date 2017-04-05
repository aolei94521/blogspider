package com.aolei.spider.dao;

import com.aolei.spider.entity.userEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface userEntityMapper {
    @Delete({
        "delete from tb_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_user (id, userName, ",
        "userPwd)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{userpwd,jdbcType=VARCHAR})"
    })
    int insert(userEntity record);

    int insertSelective(userEntity record);

    @Select({
        "select",
        "id, userName, userPwd",
        "from tb_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    userEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(userEntity record);

    @Update({
        "update tb_user",
        "set userName = #{username,jdbcType=VARCHAR},",
          "userPwd = #{userpwd,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(userEntity record);
}