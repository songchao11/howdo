package com.song.howdo.service.impl;

import com.song.howdo.mapper.PraiseMapper;
import com.song.howdo.model.Msg;
import com.song.howdo.model.Praise;
import com.song.howdo.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by songchao on 2018/3/22.
 */
@Service
@Transactional
public class PraiseServiceImpl implements PraiseService {

    @Autowired
    private PraiseMapper praiseMapper;

    public Msg addAndDeletePraise(Long userId, Long artId, String flag) {
        if("add".equals(flag)){
            praiseMapper.addArticlePraise(userId, artId);
            Praise praise = praiseMapper.queryPraise(userId, artId);
            if(praise != null){
                return Msg.success();
            }else{
                return Msg.fail();
            }
        }else{
            praiseMapper.deleteArticlePraise(userId, artId);
            Praise praise = praiseMapper.queryPraise(userId, artId);
            if(praise == null){
                return Msg.success();
            }else{
                return Msg.fail();
            }
        }
    }
}
