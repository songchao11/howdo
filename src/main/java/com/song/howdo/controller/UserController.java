package com.song.howdo.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.howdo.model.Msg;
import com.song.howdo.model.User;
import com.song.howdo.service.UserService;

/**
 * Created by songchao on 2017/12/27.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public Msg queryUsers(){
    	Object user =  SecurityUtils.getSubject().getPrincipal();
    	System.out.println("����:"+user);
        List<User> users = userService.queryUsers();
        return Msg.success().add("users", users);
    }

    /**
     * ����˻����Ƿ�ռ��
     * @param username
     * @return
     */
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    @ResponseBody
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
     * ע���û�
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public Msg register(User user){
    	return userService.addUser(user);
    }

    /**
     * ��ȡ��¼�û���Ϣ
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public Msg getUser(){
    	return userService.getUser();
    }

}
