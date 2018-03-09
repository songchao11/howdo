package com.song.howdo.service;

import java.util.List;

import com.song.howdo.model.Msg;
import com.song.howdo.model.User;

/**
 * Created by songchao on 2017/12/27.
 */
public interface UserService {

    List<User> queryUsers();

    User queryUserByAccount(String account);
    
    List<String> queryUserRoles(String account);
    
    Msg addUser(User user);
    
    Msg getUser();
}
