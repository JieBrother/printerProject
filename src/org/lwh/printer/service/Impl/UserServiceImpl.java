package org.lwh.printer.service.Impl;

import org.lwh.printer.dao.AdminMapper;
import org.lwh.printer.dao.UserMapper;
import org.lwh.printer.pojo.User;
import org.lwh.printer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> testDao() {
        return adminMapper.testDao();
    }

    @Override
    public User login_admin(User user) {
        User loginResult = adminMapper.login(user);
        System.out.println("admin " + loginResult);
        if (loginResult != null && user.getPassword().equals(loginResult.getPassword())) {
            return loginResult;
        }
        return null;
    }

    @Override
    public Boolean register_admin(User user) {
        Integer registerResult = adminMapper.register(user);
        if (registerResult > 0) {
            return true;
        }
        return false;
    }

    @Override
    public User login_user(User user) {
        User userResult = userMapper.login(user);
        System.out.println("userServer: " + userResult);
        if (userResult != null && user.getPassword().equals(userResult.getPassword())) {
            return userResult;
        }
        return null;
    }

    @Override
    public Boolean register_user(User user) {
        Integer registerResult = userMapper.register(user);
        if (registerResult > 0) {
            return true;
        }
        return false;
    }

}
