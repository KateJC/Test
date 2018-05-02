/*
 * 广州丰石科技有限公司拥有本软件版权2018并保留所有权利。
 * Copyright 2018, Guangzhou Rich Stone Data Technologies Company Limited,
 * All rights reserved.
 */

package com.kejunchi.test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kejunchi.test.entity.User;
import com.kejunchi.test.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * <b><code>UserController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018\5\1 0001 19:23.
 *
 * @author KeJunChi
 * @since test 0.0.1
 */
@RestController
@RequestMapping("/userController")
public class UserController {
    /**
     * The User service.
     */
    @Autowired
    UserService userService;

    /**
     * Post user string.
     *
     * @param user the user
     * @return the string
     */
    @RequestMapping(value = "/postUser", method = RequestMethod.POST)
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    public String postUser(@RequestBody User user) {
        userService.add(user);
        return "success";
    }

    /**
     * Gets user list.
     *
     * @return the user list
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户列表", notes = "获取全部的用户")
    public List<User> getUserList() {
        List<User> userList = userService.getUserList();
        return userList;
    }

    /**
     * Gets user.
     *
     * @param params the params
     * @return the user
     */
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "params", value = "请求参数map集合", required = true, dataType = "java.util.Map")
    @RequestMapping(value = "getUser", method = RequestMethod.POST)
    public User getUser(@RequestBody Map<String, String> params) {
        String id = params.get("id");
        User user = userService.getUser(id);
        return user;
    }


    /**
     * Update user string.
     *
     * @param user the user
     * @return the string
     */
    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    @ApiOperation(value = "更新用户", notes = "根据参数实体的id来指定更新对象")
    @ApiImplicitParam(name = "user", value = "需要更新的实体信息", required = true, dataType = "User")
    public String updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return "success";
    }

    /**
     * Delete user string.
     *
     * @param params the params
     * @return the string
     */
    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "params", value = "请求参数map集合,包含id参数的键值对", required = true, dataType = "Map")
    @RequestMapping(value = "deleteUser", method = RequestMethod.DELETE)
    public String deleteUser(@RequestBody Map<String, Object> params) {
        String id = (String) params.get("id");
        userService.deleteUser(id);
        return "success";
    }
}
