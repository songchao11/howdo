package com.song.howdo.service.impl;

import java.util.List;

import com.song.howdo.mapper.ArticleMapper;
import com.song.howdo.model.Article;
import com.song.howdo.service.FileService;
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
	@Autowired
	private FileService fileService;

	
	public Msg queryCategorys() {
		List<Category> cates = categoryMapper.queryCategorys();
		return Msg.success().add("cates", cates);
	}

	public Msg addArticle(Article article) {
		articleMapper.addArticle(article);
		Article a = articleMapper.queryArticle(article);
		if(a != null){
			fileService.addFile(a.getContent(), a.getId());
			return Msg.success();
		}
		return Msg.fail();
	}

}
