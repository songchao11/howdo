package com.song.howdo.test;

import java.util.List;

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

    @Test
    public void test(){
    	List<String> user = userMapper.queryUserRoles("admin");
    	for(String s : user){
    		System.out.println(s);	
    	}
    }

}
