package com.song.howdo.mapper;

import com.song.howdo.model.Collect;
import org.apache.ibatis.annotations.Param;

/**
 * Created by songchao on 2018/3/22.
 */
public interface CollectMapper {

    int addCollect(@Param("userId") Long userId, @Param("artId") Long artId);

    int deleteCollect(@Param("userId") Long userId, @Param("artId") Long artId);

    Collect queryCollect(@Param("userId") Long userId, @Param("artId") Long artId);
}
