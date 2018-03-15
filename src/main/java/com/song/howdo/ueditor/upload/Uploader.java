package com.song.howdo.ueditor.upload;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.song.howdo.ueditor.define.State;

public class Uploader {
    private HttpServletRequest request = null;
    private Map<String, Object> conf = null;

    public Uploader(HttpServletRequest request, Map<String, Object> conf) {
        this.request = request;
        this.conf = conf;
    }

    public State doExec() {
        String filedName = (String) this.conf.get("fieldName");
        State state = null;
        //ftpÉÏ´«ÅÐ¶Ï
        if ("true".equals(this.conf.get("useFtpUpload"))) {
            FtpUploadUtilbaidu ftpUploadUtilbaidu = new FtpUploadUtilbaidu();
            state = ftpUploadUtilbaidu.save(request, conf);
        }
        return state;
    }
}

