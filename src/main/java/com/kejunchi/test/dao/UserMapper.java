/*
 * 广州丰石科技有限公司拥有本软件版权2018并保留所有权利。
 * Copyright 2018, Guangzhou Rich Stone Data Technologies Company Limited,
 * All rights reserved.
 */

package com.kejunchi.test.dao;

import com.kejunchi.test.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b><code>UserMapper</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018\5\1 0001 19:55.
 *
 * @author KeJunChi
 * @since test 0.0.1
 */
@Mapper
// @Repository
public interface UserMapper {

    /**
     * Insert int.
     *
     * @param user the user
     * @return the int
     */
    @Insert("INSERT INTO USER(id, first_name,last_name,sex) VALUES(#{id}, #{firstName},#{lastName},#{sex})")
    int insert(User user);

    /**
     * Gets user list.
     *
     * @return the user list
     */
    /*
     * @Select("select u.id id,u.first_name firstName,u.last_name lastName,u.sex sex from user u")
     */
    // List<Map<String, Object>> getUserList();
    List<User> getUserList();

    /**
     * Gets user.
     *
     * @param id the id
     * @return the user
     */
    @Select("select u.id id,u.first_name firstName,u.last_name lastName ,u.sex sex from user u where u.id=#{id}")
    User getUser(@Param("id") String id);

    /**
     * Update user int.
     *
     * @param id the id
     * @param user the user
     * @return the int
     */
    @Update("update user set id=#{id},sex=#{sex},first_name=#{firstName},last_name=#{lastName} where id=#{id}")
    int updateUser(User user);

    /**
     * Delete user int.
     *
     * @param id the id
     * @return the int
     */
    @Delete("delete from user where id=#{id}")
    int deleteUser(@Param("id") String id);

}
