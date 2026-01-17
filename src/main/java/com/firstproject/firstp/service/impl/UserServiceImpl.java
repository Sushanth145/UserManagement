package com.firstproject.firstp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstproject.firstp.dto.Userdto;
import com.firstproject.firstp.exception.UserException;
import com.firstproject.firstp.repository.UserRepository;
import com.firstproject.firstp.model.User;
import com.firstproject.firstp.service.UserService;
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(Userdto userdto){
        User user = new User(null,userdto.getName(),userdto.getEmail());
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id){
        User user = userRepository.findById(id);
        if(user == null){
            throw new UserException(id);
        }
        return user;
    }

    @Override
    public User updateUser(Long id,Userdto userdto){
        User user = new User(id,userdto.getName(),userdto.getEmail());
        return userRepository.update(id,user);
    }

    @Override
    public void deleteUser(Long id){
        User user = userRepository.findById(id);
        if(user == null){
            throw new UserException(id);
        }
        userRepository.delete(id);
    }

}
