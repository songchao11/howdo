package com.song.howdo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@RequestMapping("/main")
	public String toMain(){
		return "main";
	}
	
}
