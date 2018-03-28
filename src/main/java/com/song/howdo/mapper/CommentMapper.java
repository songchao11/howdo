package com.song.howdo.mapper;

import com.song.howdo.model.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by songchao on 2018/3/23.
 */
public interface CommentMapper {

    int addComment(@Param("comment") Comment comment);

    Comment queryComment(@Param("comment") Comment comment);

    List<Comment> queryCommentByArtId(@Param("artId") Long artId);

    List<Long> queryCommId(@Param("list") List<Long> ids);

    List<Comment> queryCommsByIds(@Param("list") List<Long> ids);

    Comment queryCommentById(@Param("id") Long id);

}
