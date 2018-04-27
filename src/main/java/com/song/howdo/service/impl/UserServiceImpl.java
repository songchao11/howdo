package com.song.howdo.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.song.howdo.mapper.ArticleMapper;
import com.song.howdo.mapper.ConcernMapper;
import com.song.howdo.model.Concern;
import com.song.howdo.ueditor.upload.FTPUtil;
import com.song.howdo.util.AgeUtil;
import com.song.howdo.util.ConstellationUtil;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
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
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private ConcernMapper concernMapper;
    @Autowired
    private ArticleMapper articleMapper;

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
		//盐值加密
		String password =  encryptBySalt(user.getPassword(), user.getAccount());
		System.out.println(password);
		user.setPassword(password);
		String nickname = ChineseName.getName();
		System.out.println(nickname);
		user.setNickname(nickname);
		user.setHeadPic("http://119.23.77.220/images/cat.jpg");
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
	 * 密码盐值加密
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

	public Msg queryIConcerned(Long userId, Integer page, Integer size) {
		PageHelper.startPage(page, size);
		List<User> users = userMapper.queryIConcerned(userId);
		PageInfo pages = new PageInfo(users,8);
		return Msg.success().add("pageInfo", pages);
	}

	public Msg queryConcernMe(Long userId, Integer page, Integer size) {
		PageHelper.startPage(page, size);
		List<User> users = userMapper.queryConcernMe(userId);
		PageInfo pages = new PageInfo(users,8);
		return Msg.success().add("pageInfo", pages);
	}

	public Msg queryConcernNum(Long userId) {
		int concernedNum = userMapper.queryIConcernedNum(userId);
		int concernMeNum = userMapper.queryConcernMeNum(userId);
		return Msg.success().add("concernedNum",concernedNum).add("concernMeNum",concernMeNum);
	}

	public Msg queryUserById(Long userId) {
		User user = userMapper.queryUserById(userId);
		Date birthday = user.getBirthday();
		System.out.println(birthday);
		int age = 0;
		String constellation = null;
		if(birthday != null){
			AgeUtil userInfoUtil = new AgeUtil();
			ConstellationUtil constellationUtil = new ConstellationUtil();
			try {
				age = userInfoUtil.getAge(birthday);
				constellation = constellationUtil.getXingZuoName(birthday);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		user.setAge(age);
		user.setConstellation(constellation);
		System.out.println(user.getBirthday());
		return Msg.success().add("user", user);
	}

	public Msg updateUser(User user) {

		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format1.parse(user.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setBirthday(date);
		userMapper.updateUser(user);
		return Msg.success();
	}

	public Msg queryUserInfo(Long userId, Long yourId){
		User user = userMapper.queryUserById(userId);
		String followed = "";
		Concern concern = concernMapper.queryConcern(yourId, userId);
		if(yourId == userId){
			followed = "空";
		}else if(concern == null){
			followed = "关注";
		}else {
			followed = "已关注";
		}
		user.setFollowed(followed);
		Date birthday = user.getBirthday();
		int age = 0;
		String constellation = null;
		if(birthday != null){
			AgeUtil userInfoUtil = new AgeUtil();
			ConstellationUtil constellationUtil = new ConstellationUtil();
			try {
				age = userInfoUtil.getAge(birthday);
				constellation = constellationUtil.getXingZuoName(birthday);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		user.setAge(age);
		user.setConstellation(constellation);
		//查询用户的文章 粉丝 评论 喜欢数
		Long articleNum = articleMapper.queryArticleNumById(userId);
		Long commentNum = articleMapper.queryArticleCommNum(userId);
		Long observedNum = articleMapper.queryObservedNum(userId);
		Long collectNum = articleMapper.queryCollectNum(userId);
		user.setArticleNum(articleNum);
		user.setCommentNum(commentNum);
		user.setObservedNum(observedNum);
		user.setCollectNum(collectNum);
		return Msg.success().add("user",user);
	}

	public Msg uploadPhoto(MultipartFile file) {
		FTPUtil ftpUtil = new FTPUtil();
		String fileName = file.getOriginalFilename();
		System.out.println(fileName);
		Object username =  SecurityUtils.getSubject().getPrincipal();
		User user = userMapper.queryUserByAccount(username.toString());
		try {
			ftpUtil.upload(file, fileName);
			userMapper.updatePhoto("/pic/"+fileName, user.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Msg.success();
	}

	public Msg checkPassword(String account, String password) {
		String password_query = userMapper.queryPassword(account);
		String password_to = encryptBySalt(password, account);
		if(password_query.equals(password_to)){
			return Msg.success();
		}else{
			return Msg.fail();
		}

	}

	public Msg updatePassword(String account, String password, String oldPassword) {
		String password_query = userMapper.queryPassword(account);
		oldPassword = encryptBySalt(oldPassword, account);
		if(password_query.equals(oldPassword)){
			String password_salt = encryptBySalt(password, account);
			userMapper.updatePassword(account, password_salt);
			return Msg.success();
		}else{
			return Msg.fail();
		}

	}

}
