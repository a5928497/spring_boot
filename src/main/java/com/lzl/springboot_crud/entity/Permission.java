package com.lzl.springboot_crud.entity;

import javax.persistence.*;

@Entity
public class Permission {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String permission;

    @JoinColumn(name = "ROLE_ID")
    @ManyToOne
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
