package com.lzl.springboot_crud.controller;

import com.lzl.springboot_crud.entity.User;
import com.lzl.springboot_crud.service.RoleService;
import com.lzl.springboot_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
//    @Autowired
//    private UserDao userDao;
//    @Autowired
//    private RoleDao roleDao;

    @ModelAttribute
    public void getUser(@RequestParam(value = "id",required = false) Integer id, Map<String,Object> map){
        if(id!=null){
            map.put("user",userService.findById(id));
        }
    }
    @RequestMapping("/users")
    public String listUsers(Map<String,Object> map) {
       map.put("users",userService.findAll());
       return "list";
    }

    @GetMapping("/user")
    public String toAddUser(Map<String,Object> map){
        map.put("roles",roleService.getRoles());
        return "input";
    }
    @PostMapping("/user")
    public String addUser(User user){
        System.out.println(user);
        userService.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
       userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/user/{id}")
    public String toEditUser(@PathVariable("id") Integer id,Map<String,Object> map){
        map.put("user",userService.findById(id));
        map.put("roles",roleService.getRoles());
        return "input";
    }

    @PutMapping("/user")
    public String editUser(User user){
        System.out.println(user);
        userService.saveUser(user);
        return "redirect:/users";
    }
}
