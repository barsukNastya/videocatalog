package com.melenteva.service;

import com.melenteva.model.User;



public interface UserService {

    boolean getUserByNameAndPassword(String userName, String userPassword);


    public User getUserByNameAndPasswordAndIsAdmin(String userName, String userPassword, Boolean isAdmin);


}
