package com.song.howdo.controller;

import com.song.howdo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.howdo.model.Msg;
import com.song.howdo.model.User;

@Controller
public class ShiroHandler {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public Msg login(User user){
		Subject currentUser = SecurityUtils.getSubject();
		String username = user.getAccount();
		String password = user.getPassword();
		String remember = user.getRemember();
		if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            // rememberme
            if(remember == "1"){
                token.setRememberMe(true);
            }
            try {

                currentUser.login(token);
            }
            catch (AuthenticationException ae) {
            	return Msg.fail();
            }
        }
		return userService.getUser();
	}
	
}
