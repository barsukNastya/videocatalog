package com.melenteva.service;

import com.melenteva.mappers.UserMapper;
import com.melenteva.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by User on 18.02.2017.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean getUserByNameAndPassword(String userName, String userPassword) {
        User user = userMapper.getUserByNameAndPassword(userName, userPassword);

        if(user != null) {
            return true;
        }

        return false;
    }

    public User getUserByNameAndPasswordAndIsAdmin(String userName, String userPassword, Boolean isAdmin) {
        User user = userMapper.getUserByNameAndPasswordAndIsAdmin(userName, userPassword, isAdmin);

        return user;
    }

}
