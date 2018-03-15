package com.song.howdo.ueditor;

import org.springframework.context.annotation.Configuration;

@Configuration(value = "ueditor")
public class UEditorConfig {

    /**
     * config.json���ļ���ŵ�ַ
     */
    private String config;
    /**
     * �Ƿ�ͬͳһ�ϴ���ַ��ͼƬ�ϴ���ַ����Ƶ�ϴ���ַ...
     */
    private boolean unified;
    /**
     * �ļ��ϴ�·��
     */
    private String uploadPath;
    /**
     * �ļ�urlǰ׺
     */
    private String urlPrefix;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getUrlPrefix() {
        return urlPrefix;
    }

    public void setUrlPrefix(String urlPrefix) {
        this.urlPrefix = urlPrefix;
    }

    public boolean getUnified() {
        return unified;
    }

    public void setUnified(boolean unified) {
        this.unified = unified;
    }
}
