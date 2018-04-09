package com.song.howdo.controller;

import com.song.howdo.model.Article;
import com.song.howdo.service.CollectService;
import com.song.howdo.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.song.howdo.model.Msg;
import com.song.howdo.service.ArticleService;

@RestController
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private PraiseService praiseService;
	@Autowired
	private CollectService collectService;
	
	@RequestMapping("/article/main")
	public String toMain(){
		return "main";
	}
	
	@RequestMapping(value = "/article/categorys", method = RequestMethod.GET)
	public Msg queryCategorys(){
		return articleService.queryCategorys();
	}

	@RequestMapping(value = "/article", method = RequestMethod.POST)
	public Msg addArticle(Article article){
		return articleService.addArticle(article);
	}

	@RequestMapping(value = "/articles/{userId}/{page}/{size}/{isPublish}", method = RequestMethod.GET)
	public Msg queryArticles( @PathVariable Long userId,
							  @PathVariable Integer page,
							  @PathVariable Integer size,
							  @PathVariable String isPublish){
		return articleService.queryArticles(userId, page, size, isPublish);
	}

	@RequestMapping(value = "/article/total/{userId}", method = RequestMethod.GET)
	public Msg queryArticleCount(@PathVariable Long userId){
		return articleService.queryArticleCount(userId);
	}

	@RequestMapping(value = "/article/isComment", method = RequestMethod.PUT)
	public Msg updateArticleIsComment(Article article){
		Long artId = article.getId();
		String isComment = article.getIsComment();
		return articleService.updateArticleIsComment(artId, isComment);
	}

	@RequestMapping(value = "/article/{artId}", method = RequestMethod.DELETE)
	public Msg deleteArticle(@PathVariable Long artId){
		return articleService.deleteArticle(artId);
	}

	@RequestMapping(value = "/articles/search/{title}/{userId}/{page}/{size}", method = RequestMethod.GET)
	public Msg queryArticlesByDim( @PathVariable String title,
								   	@PathVariable Long userId,
							  		@PathVariable Integer page,
								    @PathVariable Integer size){
		return articleService.queryArticlesByDim(title,userId, page, size);
	}

	@RequestMapping(value = "/article/user/{artId}/{yourId}", method = RequestMethod.GET)
	public Msg queryArticleAndUser(@PathVariable Long artId, @PathVariable Long yourId){
		return articleService.queryArticleAndUser(artId, yourId);
	}

	@RequestMapping(value = "/article/praise/{userId}/{artId}/{flag}", method = RequestMethod.POST)
	public Msg addAndDeletePraise(@PathVariable Long userId,
								  @PathVariable Long artId,
								  @PathVariable String flag){
		return praiseService.addAndDeletePraise(userId, artId, flag);
	}

	@RequestMapping(value = "/article/collect/{userId}/{artId}/{flag}", method = RequestMethod.POST)
	public Msg addAndDeleteCollect(@PathVariable Long userId,
								  @PathVariable Long artId,
								  @PathVariable String flag){
		return collectService.addAndDeleteCollect(userId, artId, flag);
	}

	@RequestMapping(value = "/article/all", method = RequestMethod.GET)
	public Msg queryArticleAll(Integer page, Integer size){
		return articleService.queryArticleAll(page,size);
	}

	@RequestMapping(value = "/article/collect/{userId}/{page}/{size}", method = RequestMethod.GET)
	public Msg queryArticleCollect(@PathVariable Long userId, @PathVariable Integer page, @PathVariable Integer size){
		return articleService.queryArticleCollect(userId,page,size);
	}

	@RequestMapping(value = "/article/{artId}", method = RequestMethod.GET)
	public Msg queryArticleById(@PathVariable Long artId){
		return articleService.queryArticleById(artId);
	}

	@RequestMapping(value = "/article", method = RequestMethod.PUT)
	public Msg updateArticle(Article article){
		return articleService.updateArticle(article);
	}
}
