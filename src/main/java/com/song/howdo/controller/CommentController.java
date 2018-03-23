package com.song.howdo.controller;

import com.song.howdo.model.Comment;
import com.song.howdo.model.Msg;
import com.song.howdo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by songchao on 2018/3/23.
 */
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Msg addComment(Comment comment){
        return commentService.addComment(comment);
    }

}
