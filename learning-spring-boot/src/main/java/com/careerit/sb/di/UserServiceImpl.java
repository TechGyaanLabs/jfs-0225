package com.careerit.sb.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    public UserServiceImpl(@Autowired UserDao userDao) {
        this.userDao = userDao;
    }

    public List<String> getAllUsers() {
        List<String> users = userDao.getAllUsers();
        return users.stream()
                .map(String::trim)
                .map(String::toUpperCase)
                .toList();
    }
}
