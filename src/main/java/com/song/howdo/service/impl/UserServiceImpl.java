package com.song.howdo.service.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.song.howdo.mapper.UserMapper;
import com.song.howdo.mapper.UserRoleMapper;
import com.song.howdo.model.Msg;
import com.song.howdo.model.User;
import com.song.howdo.service.UserService;
import com.song.howdo.util.ChineseName;

/**
 * Created by songchao on 2017/12/27.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

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

	public Msg addUser(User user) {
		//将明文密码盐值加密
		String password =  encryptBySalt(user.getPassword(), user.getAccount());
		System.out.println(password);
		user.setPassword(password);
		String nickname = ChineseName.getName();
		System.out.println(nickname);
		user.setNickname(nickname);
		user.setHeadPic("e://nick.png");
		userMapper.addUser(user);
		User queryUser = userMapper.queryUserByAccount(user.getAccount());
		if(queryUser != null){
			Long userId = queryUser.getId();
			userRoleMapper.addUserRole(userId, 1L);
		}else{
			return Msg.fail();
		}
		
		return Msg.success();
	}
	
	/**
	 * 密码盐值加密方法
	 * @param credentials
	 * @return
	 */
	public static String encryptBySalt(Object credentials, String bySalt) {
		String hashAlgorithmName = "MD5";
		Object salt = ByteSource.Util.bytes(bySalt);
		int hashIterations = 1024;
		Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		String password = result.toString();
		return password;
	}

	public Msg getUser() {
		Object username =  SecurityUtils.getSubject().getPrincipal();
		if(username != null){
			User user = userMapper.queryUserByAccount(username.toString());
			return Msg.success().add("user", user);
		}
		return Msg.fail();
	}

}
