package com.lzl.springboot_crud.controller;

import com.lzl.springboot_crud.entity.User;
import com.lzl.springboot_crud.service.RoleService;
import com.lzl.springboot_crud.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public void getUser(@RequestParam(value = "id",required = false) Integer id,
                        @RequestParam(value = "password",required = false) String password,
                        Map<String,Object> map){
        //若为修改
        if(id!=null){
            User user = userService.findById(id);
            user.setRole(null);
            map.put("user",user);
        }


    }

    @ResponseBody
    @PostMapping("/checkUsername")
    public String checkUsername(@RequestParam("username") String username) {
//        System.out.println(username);
        return userService.checkUsername(username) ;
    }

    @RequestMapping("/users")
    public String listUsers(Map<String,Object> map) {
       map.put("users",userService.findAll());
       return "users/list";
    }

    @GetMapping("/user")
    public String toAddUser(Map<String,Object> map){
        map.put("roles",roleService.getRoles());
        return "users/input";
    }
    @PostMapping("/user")
    public String addUser(User user){
        user.setCreateTime(new Date());
        Object salt = ByteSource.Util.bytes(user.getUserName());;
        Object result = new SimpleHash("MD5", user.getPassword(), salt, 1024);
        user.setPassword(result.toString());
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
        return "users/input";
    }

    @PutMapping("/user")
    public String editUser(User user){
        System.out.println(user);
        userService.saveUser(user);
        return "redirect:/users";
    }
}
