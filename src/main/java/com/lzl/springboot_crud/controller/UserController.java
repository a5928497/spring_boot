package com.lzl.springboot_crud.controller;

import com.lzl.springboot_crud.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @ResponseBody
    @RequestMapping("/getUsers")
    public String printUsers() {
       return userDao.getUsers().toString();
    }

}
