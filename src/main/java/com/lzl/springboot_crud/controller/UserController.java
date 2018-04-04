package com.lzl.springboot_crud.controller;

import com.lzl.springboot_crud.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;


    @RequestMapping("/users")
    public String printUsers(Map<String,Object> map) {
       map.put("users",userDao.getUsers());
       return "list";
    }

}
