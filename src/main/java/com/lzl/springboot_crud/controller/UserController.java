package com.lzl.springboot_crud.controller;

import com.lzl.springboot_crud.dao.RoleDao;
import com.lzl.springboot_crud.dao.UserDao;
import com.lzl.springboot_crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @ModelAttribute
    public void getUser(@RequestParam(value = "id",required = false) Integer id, Map<String,Object> map){
        if(id!=null){
            map.put("user",userDao.getUser(id));
        }
    }
    @RequestMapping("/users")
    public String listUsers(Map<String,Object> map) {
       map.put("users",userDao.getUsers());
       return "list";
    }

    @GetMapping("/user")
    public String toAddUser(Map<String,Object> map){
        map.put("roles",roleDao.getRoles());
        return "input";
    }
    @PostMapping("/user")
    public String addUser(User user){
        System.out.println(user);
        userDao.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userDao.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping("/user/{id}")
    public String toEditUser(@PathVariable("id") Integer id,Map<String,Object> map){
        map.put("user",userDao.getUser(id));
        map.put("roles",roleDao.getRoles());
        return "input";
    }

    @PutMapping("/user")
    public String editUser(User user){
        System.out.println(user);
        userDao.saveUser(user);
        return "redirect:/users";
    }
}
