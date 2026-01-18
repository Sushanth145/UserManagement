package com.firstproject.firstp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstproject.firstp.dto.Userdto;
import com.firstproject.firstp.exception.UserException;
import com.firstproject.firstp.repository.UserRepository;
import com.firstproject.firstp.model.User;
import com.firstproject.firstp.service.UserService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    UserRepository userRepository;

    @Override
    public Page<User> getAllUsers(int page,int size,String sortBy,String sortDir){
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page,size,sort);
        return userRepository.findAll(pageable);
    }

    @Override
    public User createUser(Userdto userdto){
        if(userRepository.existsByEmail(userdto.getEmail())){
            throw new RuntimeException(userdto.getEmail());
        }
        User user = new User(null,userdto.getName(),userdto.getEmail());
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id){
        return userRepository.findById(id)
            .orElseThrow(() -> new UserException(id));
    }

    @Override
    public User updateUser(Long id,Userdto userdto){
        User user = new User(id,userdto.getName(),userdto.getEmail());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
