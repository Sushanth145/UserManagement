package com.firstproject.firstp.service;
import org.springframework.data.domain.Page;

import com.firstproject.firstp.dto.Userdto;
import com.firstproject.firstp.model.User;
public interface UserService {

    Page<User> getAllUsers(int page,int size,String sortBY,String sortDir);
    User createUser(Userdto userdto);

    User getUser(Long id);

    User updateUser(Long id,Userdto userdto);

    void deleteUser(Long id);
}
