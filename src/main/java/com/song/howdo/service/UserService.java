package com.song.howdo.service;

import com.song.howdo.model.User;

import java.util.List;

/**
 * Created by songchao on 2017/12/27.
 */
public interface UserService {

    List<User> queryUsers();

    User queryUserByAccount(String account);
    
    List<String> queryUserRoles(String account);
}
