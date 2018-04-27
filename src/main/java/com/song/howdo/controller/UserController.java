package com.song.howdo.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
        List<User> users = userService.queryUsers();
        return Msg.success().add("users", users);
    }

    /**
     *
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
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public Msg register(User user){
    	return userService.addUser(user);
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public Msg getUser(){
    	return userService.getUser();
    }

    @RequestMapping(value = "/user/concern/{userId}/{page}/{size}", method = RequestMethod.GET)
    @ResponseBody
    public Msg queryIConcerned(@PathVariable Long userId,
                               @PathVariable Integer page, @PathVariable Integer size){
        return userService.queryIConcerned(userId,page,size);
    }

    @RequestMapping(value = "/user/concerned/{userId}/{page}/{size}", method = RequestMethod.GET)
    @ResponseBody
    public Msg queryConcernMe(@PathVariable Long userId,
                               @PathVariable Integer page, @PathVariable Integer size){
        return userService.queryConcernMe(userId,page,size);
    }

    @RequestMapping(value = "/user/concern/num/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Msg queryConcernNum(@PathVariable Long userId){
        return userService.queryConcernNum(userId);
    }

    @RequestMapping(value = "/user/photo", method = RequestMethod.POST)
    @ResponseBody
    public Msg uploadPhoto(@RequestParam("file")MultipartFile file,
                                    HttpServletRequest request)throws IOException {
        System.out.println("开始"+file.getOriginalFilename());

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        String fileName = date + ".jpg";

//        return Msg.success();
//        ModelAndView mv = new ModelAndView();
        userService.uploadPhoto(file);
//        mv.setViewName("information.jsp");
        return Msg.success();
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Msg queryUserById(@PathVariable Long userId){
        return userService.queryUserById(userId);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateUser(User user){
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/user/information/{userId}/{yourId}", method = RequestMethod.GET)
    @ResponseBody
    public Msg queryUserInfo(@PathVariable Long userId, @PathVariable Long yourId){
        return userService.queryUserInfo(userId, yourId);
    }

    @RequestMapping(value = "/user/password/{account}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public Msg checkPassword(@PathVariable String account, @PathVariable String password){
        return userService.checkPassword(account, password);
    }
    @RequestMapping(value = "/user/password/{account}/{password}/{oldPassword}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg updatePassword(@PathVariable String account, @PathVariable String password, @PathVariable String oldPassword){
        return userService.updatePassword(account, password,oldPassword);
    }

}
