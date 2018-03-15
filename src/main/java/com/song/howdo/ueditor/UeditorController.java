package com.song.howdo.ueditor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UeditorController {

    @Autowired
    private ActionEnter actionEnter;

    /**
     * Ueditor上传文件请求接口
     * produces="application/x-javascript" 设置返回配置文件的 MIME type
     */
    @ResponseBody
    @RequestMapping(value = "/ueditor/exec", produces="application/x-javascript")
    public String exe(HttpServletRequest request) throws Exception{
        String result = actionEnter.exec(request);
        System.out.println(result);
        return result;
    }

}