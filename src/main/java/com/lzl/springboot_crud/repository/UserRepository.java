package com.lzl.springboot_crud.repository;

import com.lzl.springboot_crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT userName FROM User u WHERE u.userName = :username")
    public String findByUserName(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE u.userName = :username")
    public User getByUserName(@Param("username") String username);
}
