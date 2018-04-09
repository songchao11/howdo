package com.song.howdo.service;

import com.song.howdo.model.Article;
import com.song.howdo.model.Msg;

public interface ArticleService {

	Msg queryCategorys();

	Msg addArticle(Article article);

	Msg queryArticles(Long userId, Integer page, Integer size, String isPublish);

	Msg queryArticleCount(Long userId);

	Msg updateArticleIsComment(Long artId, String isComment);

	Msg deleteArticle(Long artId);

	Msg queryArticlesByDim(String title, Long userId, Integer page, Integer size);

	Msg queryArticleAndUser(Long artId, Long yourId);

	Msg queryArticleAll(Integer page, Integer size);

	Msg queryArticleCollect(Long userId, Integer page, Integer size);

	Msg queryArticleById(Long artId);

	Msg updateArticle(Article article);
}
