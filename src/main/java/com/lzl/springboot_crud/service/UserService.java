package com.lzl.springboot_crud.service;

import com.lzl.springboot_crud.entity.User;
import com.lzl.springboot_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
    @Transactional
    public void saveUser(User user){
        userRepository.saveAndFlush(user);
    }
    @Transactional
    public List<User> findAll(){
        return userRepository.findAll();
    }
    @Transactional
    public void addUser(User user){
        if(user.getCreateTime()==null){
            user.setCreateTime(new Date());
        }
        userRepository.saveAndFlush(user);
    }
    @Transactional
    public User findById(Integer id){
        return userRepository.findById(id).get();
    }
}