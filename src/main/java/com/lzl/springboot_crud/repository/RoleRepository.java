package com.lzl.springboot_crud.repository;

import com.lzl.springboot_crud.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
