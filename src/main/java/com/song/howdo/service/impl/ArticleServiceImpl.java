package com.song.howdo.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

	public Msg queryArticles(Long userId, Integer page, Integer size) {
		PageHelper.startPage(page, size);
		List<Article> articles = articleMapper.queryArticles(userId);
		PageInfo pages = new PageInfo(articles,5);
		return Msg.success().add("pageInfo", pages);
	}

	public Msg queryArticleCount(Long userId) {
		int articleTotal = articleMapper.queryArticleCount(userId, "Y");
		int draftTotal = articleMapper.queryArticleCount(userId, "N");
		return Msg.success().add("articleTotal", articleTotal).add("draftTotal", draftTotal);
	}

	public Msg updateArticleIsComment(Long artId, String isComment) {
		articleMapper.updateArticleIsComment(artId, isComment);
		Article article = articleMapper.queryArticleById(artId);
		return Msg.success().add("article", article);
	}

}
