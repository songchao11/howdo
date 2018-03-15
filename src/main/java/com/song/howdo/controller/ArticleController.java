package com.song.howdo.controller;

import com.song.howdo.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.song.howdo.model.Msg;
import com.song.howdo.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/main")
	public String toMain(){
		return "main";
	}
	
	@RequestMapping(value = "/categorys", method = RequestMethod.GET)
	@ResponseBody
	public Msg queryCategorys(){
		return articleService.queryCategorys();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Msg addArticle(Article article){
		return articleService.addArticle(article);
	}
	
}
