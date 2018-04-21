package com.lzl.springboot_crud.entity;

import javax.persistence.*;
import java.util.Date;
@Table(name = "USERS")
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @JoinColumn(name = "ROLE_ID")
    @ManyToOne
    private Role role;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    public User() {
    }

    public User(String userName, String password, Role role, Date createTime) {
        this.userName = userName;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", createTime=" + createTime +
                '}';
    }
}
