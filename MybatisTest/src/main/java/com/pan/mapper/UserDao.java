package com.pan.mapper;

import com.pan.model.User;

import java.util.List;

public interface UserDao {
    int insertUserOne(User user) throws Exception;
    List<User> findAll()  throws Exception;
    User findUserById(Integer id)  throws Exception;
    int updateUser(User user)  throws Exception;
    int deleteUser(Integer id)  throws Exception;

}
