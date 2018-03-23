package com.song.howdo.mapper;

import com.song.howdo.model.Comment;
import org.apache.ibatis.annotations.Param;

/**
 * Created by songchao on 2018/3/23.
 */
public interface CommentMapper {

    int addComment(@Param("comment") Comment comment);

    Comment queryComment(@Param("comment") Comment comment);

}
