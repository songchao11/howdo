package com.song.howdo.mapper;

import com.song.howdo.model.File;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by songchao on 2018/3/17.
 */
public interface FileMapper {
    int addFile(@Param("path") String path, @Param("fileType") String fileType);

    File queryFile(@Param("path") String path, @Param("fileType") String fileType);

    int addArtFile(@Param("artId") Long artId, @Param("fileId") Long fileId);

    List<File> queryFilesByArtId(@Param("artId") Long artId);
}
