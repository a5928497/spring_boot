package com.lzl.springboot_crud.dao;

import com.lzl.springboot_crud.entity.Role;
import com.lzl.springboot_crud.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {

    private static Map<Integer,User> users;
    static{
        users = new HashMap<>();
        users.put(1,new User("zhangsan",1,new Role(1,"VIP1"),new Date()));
        users.put(2,new User("lisi",1,new Role(2,"VIP2"),new Date()));
        users.put(3,new User("wangwu",3,new Role(1,"VIP3"),new Date()));
    }

    public Collection getUsers() {
        return this.users.values();
    }

    public User getUser(Integer id) {
        return this.users.get(id);
    }

    public static void main(String[] args) {
        System.out.println(new UserDao().getUser(1).toString());
    }
}
