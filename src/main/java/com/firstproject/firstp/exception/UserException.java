package com.firstproject.firstp.exception;

public class UserException extends RuntimeException {
    public UserException(Long id){
        super("User not found with id: " + id);
    }
}
