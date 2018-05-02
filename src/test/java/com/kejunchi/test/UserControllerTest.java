/*
 * 广州丰石科技有限公司拥有本软件版权2018并保留所有权利。
 * Copyright 2018, Guangzhou Rich Stone Data Technologies Company Limited,
 * All rights reserved.
 */

package com.kejunchi.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONObject;

import junit.framework.Assert;

/**
 * UserController Tester.
 * 
 * @author <Authors name>
 * @since
 * 
 *        <pre>
 * 五月 2, 2018
 *        </pre>
 * 
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 开启web上下文测试
@WebAppConfiguration
@SpringBootTest
public class UserControllerTest {
    // 注入webApplicationContext
    @Autowired
    private WebApplicationContext webApplicationContext;

    // 模拟MVC测试对象
    private MockMvc mockMvc;

    // 设置mockMvc
    @Before
    public void before() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: postUser(@RequestBody User user) 测试新增方法
     */
    @Test
    public void testPostUser() throws Exception {

        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", "1");
            jsonObject.put("firstName", "姓氏");
            jsonObject.put("lastName", "名字");
            jsonObject.put("sex", "男生");
            mockMvc.perform(
                    MockMvcRequestBuilders.post("/userController/postUser")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonObject.toJSONString()))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method: getUserList() 测试获取列表方法
     */
    @Test
    public void testGetUserList() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/userController/")
                // .param("name", "admin")
                ).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String responseString = mvcResult.getResponse().getContentAsString();
        System.out.print(responseString);
        Assert.assertEquals("请求错误", 200, status);
    }

    /**
     * Method: getUser(@RequestBody Map<String, String> params) 测试根据Id获取用户信息方法
     */
    @Test
    public void testGetUser() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "1");
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/userController/getUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonObject.toJSONString()))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String responseString = mvcResult.getResponse().getContentAsString();
        System.out.print(responseString);
        System.out.print(status);
        Assert.assertEquals("请求错误", 200, status);
    }

    /**
     * Method: updateUser(@RequestBody User user) 测试根据Id更新用户信息方法
     */
    @Test
    public void testUpdateUser() throws Exception {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", "1");
            jsonObject.put("firstName", "修改姓氏");
            jsonObject.put("lastName", "修改名字");
            jsonObject.put("sex", "修改男生");
            mockMvc.perform(
                    MockMvcRequestBuilders.post("/userController/updateUser")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonObject.toJSONString()))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method: deleteUser(@RequestBody Map<String, Object> params)
     * 测试根据Id删除用户信息方法
     */
    @Test
    public void testDeleteUser() throws Exception {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", "1");
            mockMvc.perform(
                    MockMvcRequestBuilders.delete("/userController/deleteUser")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonObject.toJSONString()))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
