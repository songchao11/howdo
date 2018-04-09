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

    Msg queryIConcerned(Long userId, Integer page, Integer size);

    Msg queryConcernMe(Long userId, Integer page, Integer size);

    Msg queryConcernNum(Long userId);

    Msg queryUserById(Long userId);

    Msg updateUser(User user);

    Msg queryUserInfo(Long userId, Long yourId);
}
