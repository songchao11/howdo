package com.song.howdo.mapper;

import com.song.howdo.model.Praise;
import org.apache.ibatis.annotations.Param;

/**
 * Created by songchao on 2018/3/22.
 */
public interface PraiseMapper {

    int addArticlePraise(@Param("userId") Long userId, @Param("artId") Long artId);

    int deleteArticlePraise(@Param("userId") Long userId, @Param("artId") Long artId);

    Praise queryPraise(@Param("userId") Long userId, @Param("artId") Long artId);

}
