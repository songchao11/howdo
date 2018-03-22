package com.song.howdo.mapper;

import com.song.howdo.model.Concern;
import org.apache.ibatis.annotations.Param;

/**
 * Created by songchao on 2018/3/21.
 */
public interface ConcernMapper {

    Concern queryConcern(@Param("userId") Long userId, @Param("observed") Long observed);

}
