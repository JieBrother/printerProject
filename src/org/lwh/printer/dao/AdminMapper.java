package org.lwh.printer.dao;

import org.lwh.printer.pojo.User;

import java.util.List;

public interface AdminMapper {

    List<User> testDao();

    User login(User user);

    Integer register(User user);

}
