package com.song.howdo.service.impl;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.song.howdo.mapper.ArticleMapper;
import com.song.howdo.mapper.ConcernMapper;
import com.song.howdo.mapper.UserMapper;
import com.song.howdo.model.Article;
import com.song.howdo.model.User;
import com.song.howdo.service.FileService;
import com.song.howdo.util.AgeUtil;
import com.song.howdo.util.ConstellationUtil;
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
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ConcernMapper concernMapper;

	
	public Msg queryCategorys() {
		List<Category> cates = categoryMapper.queryCategorys();
		return Msg.success().add("cates", cates);
	}

	public Msg addArticle(Article article) {
		System.out.println("进来");
		articleMapper.addArticle(article);
		Article a = articleMapper.queryArticle(article);
		if(a != null){
			fileService.addFile(a.getContent(), a.getId());
			return Msg.success();
		}
		return Msg.fail();
	}

	public Msg queryArticles(Long userId, Integer page, Integer size, String isPublish) {
		PageHelper.startPage(page, size);
		List<Article> articles = articleMapper.queryArticles(userId, isPublish);
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

	public Msg deleteArticle(Long artId) {
		articleMapper.deleteArticle(artId);
		Article article = articleMapper.queryArticleById(artId);
		if(article == null){
			return Msg.success();
		}
		return Msg.fail();
	}

	public Msg queryArticlesByDim(String title, Long userId, Integer page, Integer size) {
		PageHelper.startPage(page, size);
		List<Article> articles = articleMapper.queryArticlesByDim(title, userId);
		PageInfo pages = new PageInfo(articles,5);
		return Msg.success().add("pageInfo", pages);
	}

	public Msg queryArticleAndUser(Long artId, Long yourId) {
		Article article = articleMapper.queryArticleDetail(artId);
		Long userId = article.getUserId();
		User user = userMapper.queryUserById(userId);
		String followed = "";
		ConcernMapper concern = concernMapper.queryConcern(yourId, userId);
		if(yourId == userId){
			followed = "空";
		}else if(concern == null){
			followed = "关注";
		}else {
			followed = "已关注";
		}
		user.setFollowed(followed);
		Date birthday = user.getBirthday();
		int age = 0;
		String constellation = null;
		if(birthday != null){
			AgeUtil userInfoUtil = new AgeUtil();
			ConstellationUtil constellationUtil = new ConstellationUtil();
			try {
				age = userInfoUtil.getAge(birthday);
				constellation = constellationUtil.getXingZuoName(birthday);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		user.setAge(age);
		user.setConstellation(constellation);
		return Msg.success().add("user", user).add("article", article);
	}

}
