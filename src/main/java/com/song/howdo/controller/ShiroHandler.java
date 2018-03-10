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
        	// ���û����������װΪ UsernamePasswordToken ����
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            // rememberme
            if(remember == "1"){
            	System.out.println("����:"+remember);
                token.setRememberMe(true);
            }
            try {
            	// ִ�е�¼. 
                currentUser.login(token);
            } 
            // ... catch more exceptions here (maybe custom ones specific to your application?
            // ������֤ʱ�쳣�ĸ���. 
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            	System.out.println("��¼ʧ��: " + ae.getMessage());
            	return Msg.fail();
            }
        }
		return Msg.success();
	}
	
}
