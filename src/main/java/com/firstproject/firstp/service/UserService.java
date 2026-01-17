package com.firstproject.firstp.service;
import com.firstproject.firstp.dto.Userdto;
import com.firstproject.firstp.model.User;
public interface UserService {
    User createUser(Userdto userdto);

    User getUser(Long id);

    User updateUser(Long id,Userdto userdto);

    void deleteUser(Long id);
}
