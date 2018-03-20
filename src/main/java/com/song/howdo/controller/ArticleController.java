package com.song.howdo.controller;

import com.song.howdo.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.howdo.model.Msg;
import com.song.howdo.service.ArticleService;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/article/main")
	public String toMain(){
		return "main";
	}
	
	@RequestMapping(value = "/article/categorys", method = RequestMethod.GET)
	@ResponseBody
	public Msg queryCategorys(){
		return articleService.queryCategorys();
	}

	@RequestMapping(value = "/article", method = RequestMethod.POST)
	@ResponseBody
	public Msg addArticle(Article article){
		return articleService.addArticle(article);
	}

	@RequestMapping(value = "/articles/{userId}/{page}/{size}", method = RequestMethod.GET)
	@ResponseBody
	public Msg queryArticles( @PathVariable Long userId,
							  @PathVariable Integer page,
							  @PathVariable Integer size){
		return articleService.queryArticles(userId, page, size);
	}

	@RequestMapping(value = "/article/total/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public Msg queryArticleCount(@PathVariable Long userId){
		return articleService.queryArticleCount(userId);
	}

	@RequestMapping(value = "/article/isComment", method = RequestMethod.PUT)
	@ResponseBody
	public Msg updateArticleIsComment(Article article){
		Long artId = article.getId();
		String isComment = article.getIsComment();
		return articleService.updateArticleIsComment(artId, isComment);
	}
	
}
