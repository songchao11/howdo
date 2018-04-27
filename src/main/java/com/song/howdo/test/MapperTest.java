package com.song.howdo.test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.song.howdo.mapper.ArticleMapper;
import com.song.howdo.mapper.FileMapper;
import com.song.howdo.model.Article;
import com.song.howdo.model.File;
import com.song.howdo.model.User;
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
    @Autowired
    private FileMapper fileMapper;

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
        article.setCateId(2L);
        article.setEnableFlag("Y");
        article.setUserId(9L);
        article.setReadNum(0L);
        Article a = articleMapper.queryArticle(article);
        System.out.println(a.getId());
    }

    @Test
    public void test2(){
        Article article = articleMapper.queryArticleById(13L);
        String content = article.getContent();
        System.out.println(content);
        Pattern p_img = Pattern.compile("(<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>)");
        Matcher m_img = p_img.matcher(content);
        while (m_img.find()) {
            String img = m_img.group(2); //m_img.group(1) 为获得整个img标签  m_img.group(2) 为获得src的值
            System.out.println(img);
        }
    }

    @Test
    public void test3(){
        List<Article> articles = articleMapper.queryArticles(9L,"Y");
        for(Article a : articles){
            System.out.println(a);
        }
    }

    @Test
    public void test4(){
        List<Article> articles = articleMapper.queryArticleAll(1L);
        for(Article a : articles){
            System.out.println(a);
        }
    }


}
