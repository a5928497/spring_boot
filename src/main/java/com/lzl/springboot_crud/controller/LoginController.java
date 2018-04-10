package com.lzl.springboot_crud.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam("username")String username,@RequestParam("password") String password){
        //获取subject
        Subject currentUser = SecurityUtils.getSubject();
        //验证用户是否已经登录
        if(!currentUser.isAuthenticated()){
            //把用户名密码封装为Token对象
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
            //设置token的rememberme
            usernamePasswordToken.setRememberMe(true);
            try {
                //执行登录
                currentUser.login(usernamePasswordToken);
            }catch (AuthenticationException ae){
                System.out.println("登陆失败");
            }

        }
        return "redirect:/users";
    }
}
