package com.song.howdo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.howdo.model.Msg;
import com.song.howdo.model.User;

@Controller
public class ShiroHandler {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public Msg login(User user){
		Subject currentUser = SecurityUtils.getSubject();
		String username = user.getAccount();
		String password = user.getPassword();
		String remember = user.getRemember();
		if (!currentUser.isAuthenticated()) {
        	// 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            // rememberme
            if(remember == "1"){
            	System.out.println("测试:"+remember);
                token.setRememberMe(true);
            }
            try {
            	// 执行登录. 
                currentUser.login(token);
            } 
            // ... catch more exceptions here (maybe custom ones specific to your application?
            // 所有认证时异常的父类. 
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            	System.out.println("登录失败: " + ae.getMessage());
            	return Msg.fail();
            }
        }
		return Msg.success();
	}
	
}
