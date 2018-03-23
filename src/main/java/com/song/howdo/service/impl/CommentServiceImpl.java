package com.song.howdo.service.impl;

import com.song.howdo.mapper.CommentMapper;
import com.song.howdo.model.Comment;
import com.song.howdo.model.Msg;
import com.song.howdo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by songchao on 2018/3/23.
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    public Msg addComment(Comment comment) {
        commentMapper.addComment(comment);
        Comment c = commentMapper.queryComment(comment);
        if(c != null){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
