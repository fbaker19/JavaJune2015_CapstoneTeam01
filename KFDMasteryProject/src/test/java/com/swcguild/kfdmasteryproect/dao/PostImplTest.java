/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproect.dao;

import com.swcguild.kfdmasteryproject.dao.PostInterface;
import com.swcguild.kfdmasteryproject.model.Post;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 *
 * @author apprentice
 */
public class PostImplTest {
    
    private PostInterface dao;
    private SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
    
    public PostImplTest() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        
        dao = ctx.getBean("pdao", PostInterface.class);
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        //jdbcTemplate.execute("DELETE FROM posts");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addPost method, of class PostImpl.
     */
    @Test
    public void testAddGetDeletePost() throws ParseException {
        Post p = new Post();
        p.setContent("Test content");
        p.setTitle("Test Title 4");
        p.setUserId(1);
        p.setLastModifiedUserId(1);
        p.setCreateDate(dtf.parse("2015-08-06"));
        p.setLastModifiedDate(dtf.parse("2015-08-07"));
        p.setExpDate(dtf.parse("2015-12-31"));
        p.setPublished(1);
        p.setBlurb("Blurb");
                
        dao.addPost(p);
        
        Post fromDb = dao.viewPost(p.getPostId());
        
        Assert.assertEquals(fromDb, p);
        
        dao.deletePost(p.getPostId());
        
        Assert.assertNull(dao.viewPost(p.getPostId()));

    }

    /**
     * Test of editPost method, of class PostImpl.
     */
    @Test
    public void testAddEditPost() throws ParseException {
        Post p = new Post();
        p.setContent("Test content");
        p.setTitle("Test Title 4");
        p.setUserId(1);
        p.setLastModifiedUserId(1);
        p.setCreateDate(dtf.parse("2015-08-06"));
        p.setLastModifiedDate(dtf.parse("2015-08-07"));
        p.setExpDate(dtf.parse("2015-12-31"));
        p.setPublished(1);
        p.setBlurb("Blurb");
                
        dao.addPost(p);
        
        p.setTitle("New Title");
        dao.editPost(p);
        
        Post fromDb = dao.viewPost(p.getPostId());
        
        Assert.assertEquals(fromDb, p);
        
        dao.deletePost(p.getPostId());
        
        Assert.assertNull(dao.viewPost(p.getPostId()));
        
    }
//
//    /**
//     * Test of deletePost method, of class PostImpl.
//     */
//    @Test
//    public void testDeletePost() {
//    }
//
//    /**
//     * Test of viewPost method, of class PostImpl.
//     */
//    @Test
//    public void testViewPost() {
//    }
//
//    /**
//     * Test of viewAllPosts method, of class PostImpl.
//     */
//    @Test
//    public void testViewAllPosts() {
//    }
    
}
