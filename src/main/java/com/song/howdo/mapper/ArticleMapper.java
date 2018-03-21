package com.song.howdo.mapper;

import com.song.howdo.model.Article;
import com.song.howdo.util.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by songchao on 2018/3/15.
 */
public interface ArticleMapper {

    int addArticle(@Param("article") Article article);

    Article queryArticle(@Param("article") Article article);

    Article queryArticleById(@Param("id") Long id);

    List<Article> queryArticles(@Param("userId") Long userId, @Param("isPublish") String isPublish);

    int queryArticleCount(@Param("userId") Long userId, @Param("isPublish") String isPublish);

    int updateArticleIsComment(@Param("artId") Long artId, @Param("isComment") String isComment);

    int deleteArticle(@Param("artId") Long artId);

    List<Article> queryArticlesByDim(@Param("title") String title, @Param("userId") Long userId);

    Article queryArticleDetail(@Param("artId") Long artId);
}
