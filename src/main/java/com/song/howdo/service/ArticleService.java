package com.song.howdo.service;

import com.song.howdo.model.Article;
import com.song.howdo.model.Msg;

public interface ArticleService {

	Msg queryCategorys();

	Msg addArticle(Article article);
	
}
