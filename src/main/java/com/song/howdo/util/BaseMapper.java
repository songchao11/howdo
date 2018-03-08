package com.song.howdo.util;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by songchao on 2017/12/27.
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
