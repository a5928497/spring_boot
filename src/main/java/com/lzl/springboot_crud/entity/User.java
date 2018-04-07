package com.lzl.springboot_crud.entity;

import javax.persistence.*;
import java.util.Date;
@Table(name = "USERS")
@Entity
public class User {
    @Column(name = "USER_NAME")
    private String userName;
    @GeneratedValue
    @Id
    private Integer id;
    @JoinColumn(name = "ROLE_ID")
    @ManyToOne
    private Role role;
    @Column(name = "CREATE_TIME")
    private Date createTime;

    public User() {
    }

    public User(String userName, Integer id, Role role, Date createTime) {
        this.userName = userName;
        this.id = id;
        this.role = role;
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", id=" + id +
                ", role=" + role +
                ", createTime=" + createTime +
                '}';
    }
}
