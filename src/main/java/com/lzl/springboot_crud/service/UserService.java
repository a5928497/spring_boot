package com.lzl.springboot_crud.service;

import com.lzl.springboot_crud.entity.User;
import com.lzl.springboot_crud.repository.UserRepository;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
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
    public User getByUsername(String userName) {
        return userRepository.getByUserName(userName);
    }
    @Transactional
    public String checkUsername(String userName) {
//        System.out.println(userRepository.findByUserName(userName));
        return userRepository.findByUserName(userName);
    }

    @Transactional
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

    @Transactional
    public void saveUser(User user){
        userRepository.saveAndFlush(user);
    }

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    public User findById(Integer id){
        return userRepository.findById(id).get();
    }
}
