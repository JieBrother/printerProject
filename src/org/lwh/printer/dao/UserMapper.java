package org.lwh.printer.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.lwh.printer.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> testDao();

//    @Select("select user_password from user where user_name = #{name}")
    User login(User admin);

//    @Insert("insert into user values(#{id}, #{name}, #{password})")
    Integer register(User admin);

}
