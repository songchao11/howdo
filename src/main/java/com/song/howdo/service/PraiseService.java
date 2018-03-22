package com.song.howdo.service;

import com.song.howdo.model.Msg;

/**
 * Created by songchao on 2018/3/22.
 */
public interface PraiseService {

    Msg addAndDeletePraise(Long userId, Long artId, String flag);


}
