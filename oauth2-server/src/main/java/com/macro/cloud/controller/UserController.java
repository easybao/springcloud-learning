package com.macro.cloud.controller;

import com.macro.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by macro on 2019/9/30.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication) {
        return authentication.getPrincipal();
    }

    /**
     * 对外暴露的接口,只有认证授权通过,才可以访问这个接口,  授权码模式: 先获取授权码,根据授权码获取到令牌,携带令牌才可以访问此接口
     * @return
     */
    @GetMapping("/lvcai")
    public String test(Authentication authentication){
        UserDetails macro = userService.loadUserByUsername("macro");
        System.out.println(macro.toString());
        return "lvcai";
    }
}
