package com.song.howdo.mapper;

import com.song.howdo.model.Article;
import com.song.howdo.util.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by songchao on 2018/3/15.
 */
public interface ArticleMapper {

    int addArticle(@Param("article") Article article);

    Article queryArticle(@Param("article") Article article);

    Article queryArticleById(@Param("id") Long id);
}
