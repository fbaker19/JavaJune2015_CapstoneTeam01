///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package com.swcguild.kfdmasteryproject.dao;

import com.swcguild.kfdmasteryproject.model.Post;
import com.swcguild.kfdmasteryproject.model.User;
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
    private static final String SQL_DELETE_POST = "DELETE FROM posts";
    ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");

    JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
    Post p;
    Post p2;

    public PostImplTest() {

    }

    @Before
    public void setUp() throws ParseException {
        dao = ctx.getBean("pdao", PostInterface.class);

        p = new Post();
        p.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla diam tellus, efficitur vel ligula non, pretium pretium odio. Nulla fringilla sem vestibulum ipsum porta mollis. Integer tempus enim ac faucibus mattis. Aliquam sed nibh quis sem tristique dictum. Morbi dapibus gravida lobortis. Nam consectetur metus id orci tempus iaculis. Curabitur semper tellus in lacus pharetra aliquam. Fusce scelerisque dictum turpis. Phasellus congue nulla sed egestas venenatis. Aliquam a consequat ipsum. Quisque semper vel arcu ac hendrerit.");
        p.setTitle("Test Title 4");
        p.setUserId(1);
        p.setLastModifiedUserId(1);
//        p.setCreateDate(dtf.parse("2015-08-06"));
//        p.setLastModifiedDate(dtf.parse("2015-08-07"));
        p.setExpDate(dtf.parse("2015-12-31"));
        p.setPublished(1);
        p.setPending(0);
        p.setBlurb("Blurb");

        dao.publishNewPost(p);

        
    }

    @After
    public void tearDown() {
        jdbcTemplate.execute(SQL_DELETE_POST);

    }

    /**
     * Test of addPost method, of class PostImpl.
     */
    @Test
    public void testAddViewPost() throws ParseException {

        Post fromDb = dao.viewPost(p.getPostId());

        Assert.assertEquals(fromDb.getCreateDate(), p.getCreateDate());


    }
//    @Test
//    public void testDeletePost() throws ParseException {
//
//        dao.deletePost(p.getPostId());
//
//        Assert.assertNull(dao.viewPost(p.getPostId()));
//
//    }
//    
//
//    /**
//     * Test of editPost method, of class PostImpl.
//     */
//    @Test
//    public void testAddEditDeletePost() throws ParseException {
//
//        p.setTitle("New Title");
//        dao.updatePost(p);
//
//        Post fromDb = dao.viewPost(p.getPostId());
//
//        Assert.assertEquals(fromDb.getTitle(), p.getTitle());
//
//    }
//
//    /**
//     * Test of viewAllPosts method, of class PostImpl.
//     */
//    @Test
//    public void testViewAllPublishedPosts() throws ParseException {
//        
//        p2 = new Post();
//        p2.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla diam tellus, efficitur vel ligula non, pretium pretium odio. Nulla fringilla sem vestibulum ipsum porta mollis. Integer tempus enim ac faucibus mattis. Aliquam sed nibh quis sem tristique dictum. Morbi dapibus gravida lobortis. Nam consectetur metus id orci tempus iaculis. Curabitur semper tellus in lacus pharetra aliquam. Fusce scelerisque dictum turpis. Phasellus congue nulla sed egestas venenatis. Aliquam a consequat ipsum. Quisque semper vel arcu ac hendrerit.");
//        p2.setTitle("Test Title 5");
//        p2.setUserId(1);
//        p2.setLastModifiedUserId(1);
////        p2.setCreateDate(dtf.parse("2012-12-12"));
////        p2.setLastModifiedDate(dtf.parse("2015-03-14"));
//        p2.setExpDate(dtf.parse("2015-12-31"));
//        p2.setPublished(1);
//        p2.setPending(0);
//        p2.setBlurb("Blurb");
//
//        
//
//        dao.publishNewPost(p2);
//        
//        List<Post> pList = dao.viewAllPublishedPosts();
//        
//        Assert.assertEquals(2, pList.size());
//        
//        Assert.assertEquals(dao.viewPost(p.getPostId()).getTitle(), p.getTitle());
//        
//        Assert.assertEquals(dao.viewPost(p2.getPostId()).getTitle(), p2.getTitle());
//        
//    }
}

