package com.song.howdo.service.impl;

import com.song.howdo.mapper.CommentMapper;
import com.song.howdo.mapper.UserMapper;
import com.song.howdo.model.Comment;
import com.song.howdo.model.Msg;
import com.song.howdo.model.User;
import com.song.howdo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songchao on 2018/3/23.
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;

    public Msg addComment(Comment comment) {
        Long parId = comment.getParId();
        if(parId != 0){
            Comment comm = commentMapper.queryCommentById(parId);
            User user = userMapper.queryUserById(comm.getUserId());
            comment.setContent("回复"+user.getNickname()+":"+comment.getContent());
        }
        commentMapper.addComment(comment);
        Comment c = commentMapper.queryComment(comment);
        if(c != null){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    public Msg queryComment(Long artId) {
        List<Comment> comments = commentMapper.queryCommentByArtId(artId);
        for(Comment c : comments){
            List<Comment> comms = new ArrayList<Comment>();//留言下的回复集合
            List<Long> idResult = new ArrayList<Long>();//留言下所有回复id
            List<Long> ids = new ArrayList<Long>();
            ids.add(c.getId());
            ids = commentMapper.queryCommId(ids);
            while(!ids.isEmpty()){
                idResult.addAll(ids);
                ids = commentMapper.queryCommId(ids);
            }
            if(!idResult.isEmpty()){
                comms = commentMapper.queryCommsByIds(idResult);
                c.setChildComm(comms);
            }
        }
        return Msg.success().add("comments", comments);
    }
}
