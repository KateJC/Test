/*
 * 广州丰石科技有限公司拥有本软件版权2018并保留所有权利。
 * Copyright 2018, Guangzhou Rich Stone Data Technologies Company Limited,
 * All rights reserved.
 */

package com.kejunchi.test.service;

import java.util.List;

import com.kejunchi.test.entity.User;

/**
 * <b><code>UserService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018\5\1 0001 19:58.
 *
 * @author KeJunChi
 * @since test 0.0.1
 */
public interface UserService {
    /**
     * Add string.
     *
     * @param user the user
     * @return the string
     */
    public String add(User user);

    /**
     * Gets user list.
     *
     * @return the user list
     */
    public List<User> getUserList();

    /**
     * Gets user.
     *
     * @param id the id
     * @return the user
     */
    public User getUser(String id);

    /**
     * Delete user int.
     *
     * @param id the id
     * @return the int
     */
    public int deleteUser(String id);

    /**
     * Update user int.
     *
     * @param id the id
     * @param user the user
     * @return the int
     */
    public int updateUser(User user);
}
