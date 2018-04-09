package com.song.howdo.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by songchao on 2018/3/29.
 */
public class FileDto {

    private Long userId;
    private MultipartFile file;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "FileDto{" +
                "userId=" + userId +
                ", file=" + file +
                '}';
    }
}
