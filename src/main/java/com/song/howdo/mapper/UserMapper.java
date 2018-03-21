package com.song.howdo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.song.howdo.model.User;
import com.song.howdo.util.BaseMapper;

public interface UserMapper extends BaseMapper<User> {
    List<User> queryUsers();
    
    User queryUserByAccount(@Param("account") String account);
    
    List<String> queryUserRoles(@Param("account") String account);
    
    int addUser(@Param("user") User user);

    User queryUserById(@Param("id") Long id);
}