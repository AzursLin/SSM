package com.hctek.dao;

import com.hctek.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(int id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> getAllUsers();
}