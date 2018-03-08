package com.song.howdo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.howdo.mapper.UserMapper;
import com.song.howdo.model.User;
import com.song.howdo.service.UserService;

/**
 * Created by songchao on 2017/12/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> queryUsers() {
        List<User> users = userMapper.queryUsers();
        return users;
    }

	public User queryUserByAccount(String account) {
		return userMapper.queryUserByAccount(account);
	}

	public List<String> queryUserRoles(String account) {
		return userMapper.queryUserRoles(account);
	}

}
