package com.song.howdo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.song.howdo.model.User;
import com.song.howdo.util.BaseMapper;

public interface UserMapper extends BaseMapper<User> {
    List<User> queryUsers();
    
    User queryUserByAccount(@Param("account") String account);

    User queryUserByAccount1(@Param("account") String account);
    
    List<String> queryUserRoles(@Param("account") String account);
    
    int addUser(@Param("user") User user);

    User queryUserById(@Param("id") Long id);

    List<User> queryIConcerned(@Param("userId") Long userId);

    List<User> queryConcernMe(@Param("userId") Long userId);

    int queryIConcernedNum(@Param("userId") Long userId);

    int queryConcernMeNum(@Param("userId") Long userId);

    int updateUser(@Param("user") User user);

    int updatePhoto(@Param("headPic") String headPic, @Param("id") Long id);

    String queryPassword(@Param("account") String account);

    int updatePassword(@Param("account") String account, @Param("password") String password);

    int addFollowed(@Param("userId") Long userId, @Param("observed") Long observed);

    int delFollowed(@Param("userId") Long userId, @Param("observed") Long observed);
}