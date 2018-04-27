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

    Long queryArticleNumById(@Param("userId") Long userId);

    Long queryArticleCommNum(@Param("userId") Long userId);

    Long queryObservedNum(@Param("userId") Long userId);

    Long queryCollectNum(@Param("userId") Long userId);

    int updateArticleReadNum(@Param("artId") Long artId, @Param("readNum") Long readNum);

    Long queryCommNum(@Param("artId") Long artId);

    Long queryPraiseNum(@Param("artId") Long artId);

    Long queryCollNum(Long artId);

    List<Article> queryArticleAll(@Param("cateId") Long cateId);

    List<Article> queryArticleCollect(@Param("userId") Long userId);

    int updateArticle(@Param("article") Article article);

    List<Article> queryFeatureArticle();

    List<Article> queryArticlesByAdmin(@Param("enableFlag") String enableFlag);

    List<Article> queryArticlesByDimAdmin(@Param("title") String title);

    int queryArticleCountAdmin(@Param("enable") String enable);

    int banArticle(@Param("artId") Long artId, @Param("enable") String enable);

    List<Article> searchArticles(@Param("title") String title);
}
