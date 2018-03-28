package com.song.howdo.service.impl;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.song.howdo.mapper.*;
import com.song.howdo.model.*;
import com.song.howdo.service.FileService;
import com.song.howdo.util.AgeUtil;
import com.song.howdo.util.ConstellationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	@Autowired
	private PraiseMapper praiseMapper;
	@Autowired
	private CollectMapper collectMapper;
	@Autowired
	private FileMapper fileMapper;

	
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
		Long readNum = article.getReadNum();
		articleMapper.updateArticleReadNum(artId, readNum+1);
		article.setCommentNum(articleMapper.queryCommNum(artId));
		article.setPraiseNum(articleMapper.queryPraiseNum(artId));
		article.setCollectNum(articleMapper.queryCollNum(artId));
		Long userId = article.getUserId();
		User user = userMapper.queryUserById(userId);
		String followed = "";
		String isPraise = "";
		String isCollect = "";
		Concern concern = concernMapper.queryConcern(yourId, userId);
		Praise praise = praiseMapper.queryPraise(yourId,artId);
		Collect collect = collectMapper.queryCollect(yourId, artId);
		if(yourId == userId){
			followed = "空";
		}else if(concern == null){
			followed = "关注";
		}else {
			followed = "已关注";
		}
		if(yourId == userId){
			isPraise = "空";
		}else if(praise == null){
			isPraise = "点赞";
		}else if(praise != null){
			isPraise = "已点赞";
		}
		if(yourId == userId){
			isCollect = "空";
		}else if(collect == null){
			isCollect = "收藏";
		}else if(collect != null){
			isCollect = "已收藏";
		}
		user.setFollowed(followed);
		article.setIsPraise(isPraise);
		article.setIsCollect(isCollect);
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
		//查询用户的文章 粉丝 评论 喜欢数
		Long articleNum = articleMapper.queryArticleNumById(userId);
		Long commentNum = articleMapper.queryArticleCommNum(userId);
		Long observedNum = articleMapper.queryObservedNum(userId);
		Long collectNum = articleMapper.queryCollectNum(userId);
		user.setArticleNum(articleNum);
		user.setCommentNum(commentNum);
		user.setObservedNum(observedNum);
		user.setCollectNum(collectNum);
		return Msg.success().add("user", user).add("article", article);
	}

	public Msg queryArticleAll(Integer page, Integer size) {
		PageHelper.startPage(page, size);
		List<Article> articles = articleMapper.queryArticleAll();
		for(Article a:articles){
			List<File> files = fileMapper.queryFilesByArtId(a.getId());
			if(files.isEmpty()){
				File file = new File();
				file.setPath("http://119.23.77.220/images/cat.jpg");
				files.add(file);
			}
			a.setFiles(files);
		}
		PageInfo pages = new PageInfo(articles,12);
		return Msg.success().add("pageInfo",pages);
	}

	public Msg queryArticleCollect(Long userId, Integer page, Integer size) {
		PageHelper.startPage(page, size);
		List<Article> articles = articleMapper.queryArticleCollect(userId);
		for(Article a:articles){
			List<File> files = fileMapper.queryFilesByArtId(a.getId());
			if(files.isEmpty()){
				File file = new File();
				file.setPath("http://119.23.77.220/images/cat.jpg");
				files.add(file);
			}
			a.setFiles(files);
		}
		PageInfo pages = new PageInfo(articles,8);
		return Msg.success().add("pageInfo",pages);
	}

}
