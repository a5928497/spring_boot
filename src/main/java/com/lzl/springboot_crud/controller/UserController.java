package com.lzl.springboot_crud.controller;

import com.lzl.springboot_crud.dao.RoleDao;
import com.lzl.springboot_crud.dao.UserDao;
import com.lzl.springboot_crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

//    @ModelAttribute
//    public void getUser(@RequestParam(value = "id",required = false) Integer id, Map<String,Object> map){
//        if(id==null)
//    }
    @RequestMapping("/users")
    public String listUsers(Map<String,Object> map) {
       map.put("users",userDao.getUsers());
       return "list";
    }

    @RequestMapping("/toAdd")
    public String toAddUser(Map<String,Object> map){
        map.put("roles",roleDao.getRoles());
        return "input";
    }
    @RequestMapping("/add")
    public String addUser(User user){
        System.out.println(user);
        userDao.addUser(user);
        return "redirect:/users";
    }

}
