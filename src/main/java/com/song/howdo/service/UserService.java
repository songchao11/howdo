package com.song.howdo.service;

import java.io.InputStream;
import java.util.List;

import com.song.howdo.model.Msg;
import com.song.howdo.model.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

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

    Msg uploadPhoto(MultipartFile file, HttpServletRequest request);

    Msg checkPassword(String account, String password);

    Msg updatePassword(String account, String password, String oldPassword);

    Msg addFollowed(Long userId, Long observed);

    Msg delFollowed(Long userId, Long observed);
}
