package com.lzl.springboot_crud.repository;

import com.lzl.springboot_crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
