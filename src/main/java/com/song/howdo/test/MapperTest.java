package com.song.howdo.test;

import java.util.List;

import com.song.howdo.mapper.ArticleMapper;
import com.song.howdo.model.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.song.howdo.mapper.UserMapper;

/**
 * Created by songchao on 2017/12/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MapperTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void test(){
    	List<String> user = userMapper.queryUserRoles("admin");
    	for(String s : user){
    		System.out.println(s);	
    	}
    }

    @Test
    public void test1(){
        Article article = new Article();
        article.setTitle("测试6");
        article.setContent("测试6");
        article.setIsPublish("Y");
        article.setCateId(1L);
        article.setEnableFlag("Y");
        article.setUserId(1L);
        article.setReadNum(0L);
        Article a = articleMapper.queryArticle(article);
        System.out.println(a.getId());
    }

}
