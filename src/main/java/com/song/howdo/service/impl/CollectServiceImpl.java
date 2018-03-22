package com.song.howdo.service.impl;

import com.song.howdo.mapper.CollectMapper;
import com.song.howdo.model.Collect;
import com.song.howdo.model.Msg;
import com.song.howdo.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by songchao on 2018/3/22.
 */
@Service
@Transactional
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    public Msg addAndDeleteCollect(Long userId, Long artId, String flag) {
        if("add".equals(flag)){
            collectMapper.addCollect(userId, artId);
            Collect collect = collectMapper.queryCollect(userId, artId);
            if(collect != null){
                return Msg.success();
            }else{
                return Msg.fail();
            }
        }else{
            collectMapper.deleteCollect(userId, artId);
            Collect collect = collectMapper.queryCollect(userId, artId);
            if(collect == null){
                return Msg.success();
            }else{
                return Msg.fail();
            }
        }
    }
}
