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
	public Msg queryArticleAll(Integer page, Integer size, Long cateId){
		return articleService.queryArticleAll(cateId, page, size);
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

	@RequestMapping(value = "/article/feature", method = RequestMethod.GET)
	public Msg queryArticleByCategory(){
		return articleService.queryFeatureArticle();
	}

	@RequestMapping(value = "/articles/admin/{enable}/{page}/{size}")
	public Msg queryArticlesByAdmin(@PathVariable String enable,
									@PathVariable Integer page,
									@PathVariable Integer size){
		return articleService.queryArticlesByAdmin(enable, page, size);
	}

	@RequestMapping(value = "/articles/search/admin/{title}/{page}/{size}", method = RequestMethod.GET)
	public Msg queryArticlesByDimAdmin( @PathVariable String title,
								   @PathVariable Integer page,
								   @PathVariable Integer size){
		return articleService.queryArticlesByDimAdmin(title, page, size);
	}

	@RequestMapping(value = "/article/total/admin", method = RequestMethod.GET)
	public Msg queryArticleCountAdmin(){
		return articleService.queryArticleCountAdmin();
	}

	@RequestMapping(value = "/article/ban/{artId}/{enable}", method = RequestMethod.PUT)
	public Msg banArticle(@PathVariable Long artId, @PathVariable String enable){
		return articleService.banArticle(artId, enable);
	}

	@RequestMapping(value = "/article/search", method = RequestMethod.GET)
	public Msg searchArticles(Integer page, Integer size, String title){
		return articleService.searchArticles(title, page,size);
	}

}
