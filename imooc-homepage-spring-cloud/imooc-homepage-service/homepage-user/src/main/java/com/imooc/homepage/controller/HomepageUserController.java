package com.imooc.homepage.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.homepage.UserInfo;
import com.imooc.homepage.service.IUserService;
import com.imooc.homepage.vo.CreateUserRequest;
import com.imooc.homepage.vo.UserCourseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>用户对外服务接口</h1>
 * Created by Qinyi.
 */
@Slf4j
@RestController
public class HomepageUserController {

    /** 用户服务 */
    private final IUserService userService;

    @Autowired
    public HomepageUserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * <h2>创建用户</h2>
     * 127.0.0.1:7000/homepage-user/create/user
     * 127.0.0.1:9000/imooc/homepage-user/create/user
     * {
     * 	"username": "qinyi_01",
     * 	"email": "qinyi_01@imooc.com"
     * }
     * */
    @PostMapping("/create/user")
    public UserInfo createUser(@RequestBody CreateUserRequest request) {

        log.info("<homepage-user>: create user -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }

    /**
     * <h2>获取用户信息</h2>
     * 127.0.0.1:7000/homepage-user/get/user?id=
     * 127.0.0.1:9000/imooc/homepage-user/get/user?id=
     * */
    @GetMapping("/get/user")
    public UserInfo getUserInfo(Long id) {

        log.info("<homepage-user>: get user -> {}", id);
        return userService.getUserInfo(id);
    }

    /**
     * <h2>获取用户课程信息</h2>
     * 127.0.0.1:7000/homepage-user/get/user/course?id=
     * 127.0.0.1:9000/imooc/homepage-user/get/user/course?id=
     * */
    @GetMapping("/get/user/course")
    public UserCourseInfo getUserCourseInfo(Long id) {

        log.info("<homepage-user>: get user course info -> {}", id);
        return userService.getUserCourseInfo(id);
    }
}
