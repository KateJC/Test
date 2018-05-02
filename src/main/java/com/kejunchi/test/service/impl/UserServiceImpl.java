/*
 * 广州丰石科技有限公司拥有本软件版权2018并保留所有权利。
 * Copyright 2018, Guangzhou Rich Stone Data Technologies Company Limited,
 * All rights reserved.
 */

package com.kejunchi.test.service.impl;

import com.kejunchi.test.dao.UserMapper;
import com.kejunchi.test.entity.User;
import com.kejunchi.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <b><code>UserServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018\5\1 0001 20:01.
 *
 * @author KeJunChi
 * @since test 0.0.1
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    /**
     *
     */
    @Autowired
    UserMapper userMapper;

    @Override
    public String add(User user) {
        userMapper.insert(user);
        return "返回主键";
    }

    @Override
    public int deleteUser(String id) {
        System.out.print("");
        int i = userMapper.deleteUser(id);
        return i;
    }

    @Override
    public int updateUser(User user) {
        int i = userMapper.updateUser(user);
        return i;
    }

    @Override
    public User getUser(String id) {
        User user = userMapper.getUser(id);
        return user;
    }

    @Override
    public List<User> getUserList() {
        List<User> userList = userMapper.getUserList();
        return userList;
    }
}
