package com.song.howdo.service.impl;

import java.util.List;

import com.song.howdo.mapper.ArticleMapper;
import com.song.howdo.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.howdo.mapper.CategoryMapper;
import com.song.howdo.model.Category;
import com.song.howdo.model.Msg;
import com.song.howdo.service.ArticleService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private ArticleMapper articleMapper;
	
	public Msg queryCategorys() {
		List<Category> cates = categoryMapper.queryCategorys();
		return Msg.success().add("cates", cates);
	}

	public Msg addArticle(Article article) {
		articleMapper.addArticle(article);
		Article a = articleMapper.queryArticle(article);
		if(a != null){
			return Msg.success();
		}
		return Msg.fail();
	}

}
