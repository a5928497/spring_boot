package com.lzl.springboot_crud.service;

import com.lzl.springboot_crud.entity.Role;
import com.lzl.springboot_crud.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public void deleteById(Integer id) {
        roleRepository.deleteById(id);
    }
    @Transactional(readOnly = true)
    public Role findById(Integer id){
        return roleRepository.findById(id).get();
    }
    @Transactional
    public void addRole(Role role) {
        roleRepository.saveAndFlush(role);
    }

    @Transactional(readOnly = true)
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
