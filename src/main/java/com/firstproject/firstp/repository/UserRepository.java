package com.firstproject.firstp.repository;

import org.springframework.stereotype.Repository;
import com.firstproject.firstp.model.User;
import java.util.*;
@Repository
public class UserRepository {
    private final Map<Long,User> users = new HashMap<>();
    private Long idCounter = 1L;

    public User save(User user){
        user.setId(idCounter++);
        users.put(user.getId(),user);
        return user;
    }

    public User findById(Long id){
        return users.get(id);
    }

    public User update(Long id,User user){
        users.put(id,user);
        return user;
    }

    public void delete(Long id){
        users.remove(id);
    }
}
