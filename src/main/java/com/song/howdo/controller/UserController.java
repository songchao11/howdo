package com.song.howdo.controller;

import java.io.File;
import java.util.List;

import com.song.howdo.model.FileDto;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.song.howdo.model.Msg;
import com.song.howdo.model.User;
import com.song.howdo.service.UserService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by songchao on 2017/12/27.
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Msg queryUsers(){
    	Object user =  SecurityUtils.getSubject().getPrincipal();
        List<User> users = userService.queryUsers();
        return Msg.success().add("users", users);
    }

    /**
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public Msg checkUser(@RequestParam String username){
    	Object useraa =  SecurityUtils.getSubject().getPrincipal();
    	User user = userService.queryUserByAccount(username);
    	if(user == null){
    		return Msg.success();
    	}else{
    		return Msg.fail();
    	}
    }
    
    /**
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Msg register(User user){
    	return userService.addUser(user);
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Msg getUser(){
    	return userService.getUser();
    }

    @RequestMapping(value = "/user/concern/{userId}/{page}/{size}", method = RequestMethod.GET)
    public Msg queryIConcerned(@PathVariable Long userId,
                               @PathVariable Integer page, @PathVariable Integer size){
        return userService.queryIConcerned(userId,page,size);
    }

    @RequestMapping(value = "/user/concerned/{userId}/{page}/{size}", method = RequestMethod.GET)
    public Msg queryConcernMe(@PathVariable Long userId,
                               @PathVariable Integer page, @PathVariable Integer size){
        return userService.queryConcernMe(userId,page,size);
    }

    @RequestMapping(value = "/user/concern/num/{userId}", method = RequestMethod.GET)
    public Msg queryConcernNum(@PathVariable Long userId){
        return userService.queryConcernNum(userId);
    }

    @RequestMapping(value = "/user/photo", method = RequestMethod.POST)
    public Msg uploadPhoto(@RequestParam(value="file",required=false)MultipartFile file,
                           HttpServletRequest request){
        System.out.println(request.getParameter("file"));
        return Msg.success();
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public Msg queryUserById(@PathVariable Long userId){
        return userService.queryUserById(userId);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public Msg updateUser(User user){
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/user/information/{userId}/{yourId}", method = RequestMethod.GET)
    public Msg queryUserInfo(@PathVariable Long userId, @PathVariable Long yourId){
        return userService.queryUserInfo(userId, yourId);
    }

}
