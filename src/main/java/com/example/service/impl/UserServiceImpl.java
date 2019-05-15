package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user){
        this.userMapper.insertUser(user);
    }

    @Override
    public List<User> findUserAll(){
        return this.userMapper.findUserAll();
    }

    @Override
    public User findUserById(Integer id){
        return this.userMapper.findUserById(id);
    }

    @Override
    public void updateUser(User user){
        this.userMapper.updateUser(user);
    }

    @Override
    public void deleteUserById(Integer id){
        this.userMapper.deleteUserById(id);
    }
}
