package com.lzl.springboot_crud.dao;

import com.lzl.springboot_crud.entity.Role;
import com.lzl.springboot_crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {

    @Autowired
    private RoleDao roleDao;

    private static Map<Integer,User> users;
    private static Integer id;
    static{
        users = new HashMap<>();
        id = 3;
        users.put(1,new User("zhangsan",1,new Role(1,"VIP1"),new Date()));
        users.put(2,new User("lisi",2,new Role(2,"VIP2"),new Date()));
        users.put(3,new User("wangwu",3,new Role(1,"VIP3"),new Date()));
    }

    public Collection getUsers() {
        return this.users.values();
    }

    public User getUser(Integer id) {
        return this.users.get(id);
    }

    public void saveUser(User user){
        Role role =  user.getRole();
        role.setRoleName(roleDao.getRole(role.getId()));
        if(user.getId()==null){
            id=++this.id;
            user.setId(id);
            user.setCreateTime(new Date());
            users.put(id,user);
            return;
        }
        users.put(user.getId(),user);
    }

    public void removeUser(Integer id){
        users.remove(id);
    }

    public static void main(String[] args) {
        System.out.println(new UserDao().getUser(1).toString());
    }
}
