/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.dao;

import com.swcguild.kfdmasteryproject.dao.PostInterface;
import com.swcguild.kfdmasteryproject.model.Post;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

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
        p.setPending(1);
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
    public void testAddEditDeletePost() throws ParseException {
        Post p = new Post();
        p.setContent("Test content");
        p.setTitle("Test Title 4");
        p.setUserId(1);
        p.setLastModifiedUserId(1);
        p.setCreateDate(dtf.parse("2015-08-06"));
        p.setLastModifiedDate(dtf.parse("2015-08-07"));
        p.setExpDate(dtf.parse("2015-12-31"));
        p.setPublished(1);
        p.setPending(1);
        p.setBlurb("Blurb");
                
        dao.addPost(p);
        
        p.setTitle("New Title");
        dao.editPost(p);
        
        Post fromDb = dao.viewPost(p.getPostId());
        
        Assert.assertEquals(fromDb, p);
        
        dao.deletePost(p.getPostId());
        
        Assert.assertNull(dao.viewPost(p.getPostId()));
        
    }


    /**
     * Test of viewPost method, of class PostImpl.
     */
    @Test
    public void testAddViewDeletePost() throws ParseException {
        Post p = new Post();
        p.setContent("Test content");
        p.setTitle("Test Title 4");
        p.setUserId(1);
        p.setLastModifiedUserId(1);
        p.setCreateDate(dtf.parse("2015-08-06"));
        p.setLastModifiedDate(dtf.parse("2015-08-07"));
        p.setExpDate(dtf.parse("2015-12-31"));
        p.setPublished(1);
        p.setPending(1);
        p.setBlurb("Blurb");

        dao.addPost(p);
        
        Post fromDb = dao.viewPost(p.getPostId());
        
        Assert.assertEquals(fromDb, p);
        
        dao.deletePost(p.getPostId());
        
        Assert.assertNull(dao.viewPost(p.getPostId()));
        
        
    }

    /**
     * Test of viewAllPosts method, of class PostImpl.
     */
    @Test
    public void testViewAllPosts() throws ParseException {
        
        Post p = new Post();
        p.setContent("Test content");
        p.setTitle("Test Title 4");
        p.setUserId(1);
        p.setLastModifiedUserId(1);
        p.setCreateDate(dtf.parse("2015-08-06"));
        p.setLastModifiedDate(dtf.parse("2015-08-07"));
        p.setExpDate(dtf.parse("2015-12-31"));
        p.setPublished(1);
        p.setPending(1);
        p.setBlurb("Blurb");

        dao.addPost(p);
        
        Post p2 = new Post();
        p2.setContent("Test content");
        p2.setTitle("Test Title 5");
        p2.setUserId(1);
        p2.setLastModifiedUserId(1);
        p2.setCreateDate(dtf.parse("2015-08-06"));
        p2.setLastModifiedDate(dtf.parse("2015-08-07"));
        p2.setExpDate(dtf.parse("2015-12-31"));
        p2.setPublished(1);
        p2.setPending(1);
        p2.setBlurb("Blurb5");

        dao.addPost(p2);
        
        List<Post> pList = dao.viewAllPublishedPosts();
        
        Assert.assertEquals(4, pList.size());
        
        Assert.assertEquals(pList.get(0).getTitle(), p.getTitle());
        
        Assert.assertEquals(pList.get(1).getTitle(), p2.getTitle());
        
        dao.deletePost(p2.getPostId());
        
        pList = dao.viewAllPublishedPosts();
        
        Assert.assertEquals(3, pList.size());
        
        Assert.assertNull(dao.viewPost(p2.getPostId()));
        
        dao.deletePost(p.getPostId());
        
        pList = dao.viewAllPublishedPosts();
        
        Assert.assertEquals(2, pList.size());
        
    }
    
}
