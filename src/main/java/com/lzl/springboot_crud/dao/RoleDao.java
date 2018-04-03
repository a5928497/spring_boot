package com.lzl.springboot_crud.dao;


import com.lzl.springboot_crud.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class RoleDao {
    private static Map<Integer,Role> roles;
    static {
        roles = new HashMap<>();
        roles.put(1,new Role(1,"VIP1"));
        roles.put(2,new Role(2,"VIP2"));
        roles.put(3,new Role(3,"VIP3"));
    }

    public Collection getRoles(){
        return this.roles.values();
    }

    public Role getRole(Integer id){
        return this.roles.get(id);
    }


}
