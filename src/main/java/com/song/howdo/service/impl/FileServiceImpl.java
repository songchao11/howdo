package com.song.howdo.service.impl;

import com.song.howdo.mapper.FileMapper;
import com.song.howdo.model.File;
import com.song.howdo.service.FileService;
import com.song.howdo.util.FileUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by songchao on 2018/3/17.
 */
@Service
@Transactional
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    public void addFile(String content, Long artId) {
        //从 content 中取出图片地址
        FileUrl fileUrl = new FileUrl();
        List<String> imgUrls = fileUrl.getFileUrl(content);
        for(String s : imgUrls){
            fileMapper.addFile(s, "img");
            File file = fileMapper.queryFile(s, "img");
            fileMapper.addArtFile(artId, file.getId());
        }
    }
}
