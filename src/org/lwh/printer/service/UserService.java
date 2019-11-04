package org.lwh.printer.service;

import org.lwh.printer.pojo.User;

import java.util.List;

public interface UserService {

    List<User> testDao();

    User login_admin(User admin);

    Boolean register_admin(User admin);

    User login_user(User user);

    Boolean register_user(User user);




}
