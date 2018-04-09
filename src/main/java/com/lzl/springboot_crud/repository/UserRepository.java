package com.lzl.springboot_crud.repository;

import com.lzl.springboot_crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {
//    @Query(value = "UPDATE User u SET u.userName=:username,u.role=:role,u")
//    public void updateUser();
//
//    @Query(value = "UPDATE User u SET u.password = :password WHERE u.id = :id")
//    public void changePassword();
}
