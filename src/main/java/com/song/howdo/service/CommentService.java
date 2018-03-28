package com.song.howdo.service;

import com.song.howdo.model.Comment;
import com.song.howdo.model.Msg;

/**
 * Created by songchao on 2018/3/23.
 */
public interface CommentService {

    Msg addComment(Comment comment);

    Msg queryComment(Long artId);

}
