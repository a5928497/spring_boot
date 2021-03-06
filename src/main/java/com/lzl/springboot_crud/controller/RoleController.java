package com.lzl.springboot_crud.controller;

import com.lzl.springboot_crud.entity.Role;
import com.lzl.springboot_crud.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;
//    @ModelAttribute
//    public void getRole(@RequestParam("id") Integer id,Map<String,Object> map){
//
//        }
    @DeleteMapping("role/{id}")
    public String deleteRole(@PathVariable("id") Integer id) {
        roleService.deleteById(id);
        return "redirect:/roles";
    }
    @PutMapping("role")
    public String editRole(Role role){
        roleService.addRole(role);
        return "redirect:/roles";
    }
    @GetMapping("/role/{id}")
    public String toEdit(@PathVariable("id") Integer id,Map<String,Object> map){
        System.out.println(roleService.findById(id));
        map.put("role",roleService.findById(id));
        return "roles/input";
    }

    @GetMapping("/roles")
    public String findAll(Map<String,Object> map){
        map.put("roles",roleService.getRoles());
        return "roles/list";
    }
    //前往添加页面
    @GetMapping("/role")
    public String toAddRole(){
        return "roles/input";
    }

    @PostMapping("role")
    public String addRole(Role role){
        System.out.println(role);
        roleService.addRole(role);
        return "redirect:/roles";
    }
}
