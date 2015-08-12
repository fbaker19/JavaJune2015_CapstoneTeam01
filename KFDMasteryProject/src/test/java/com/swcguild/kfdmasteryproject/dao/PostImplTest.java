/////*
//// * To change this license header, choose License Headers in Project Properties.
//// * To change this template file, choose Tools | Templates
//// * and open the template in the editor.
//// */
////package com.swcguild.kfdmasteryproject.dao;
////
////import com.swcguild.kfdmasteryproject.dao.PostInterface;
////import com.swcguild.kfdmasteryproject.model.Post;
////import java.text.ParseException;
////import java.text.SimpleDateFormat;
////import java.util.List;
////import org.junit.After;
////import org.junit.Assert;
////import org.junit.Before;
////import org.junit.Test;
////import org.springframework.context.ApplicationContext;
////import org.springframework.context.support.ClassPathXmlApplicationContext;
////import org.springframework.jdbc.core.JdbcTemplate;
////
/////**
//// *
//// * @author apprentice
//// */
////public class PostImplTest {
////    
////    private PostInterface dao;
////    private SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
////    private static final String SQL_DELETE_POST = "DELETE FROM posts WHERE post_id >4";
////    Post p;
////    Post p2;
////    
////    public PostImplTest() {
////        
////    }
////
//// 
////    
////    @Before
////    public void setUp() throws ParseException {
////        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
////        
////        dao = ctx.getBean("pdao", PostInterface.class);
////        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
////        jdbcTemplate.execute(SQL_DELETE_POST);
////        
////        p = new Post();
////        p.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla diam tellus, efficitur vel ligula non, pretium pretium odio. Nulla fringilla sem vestibulum ipsum porta mollis. Integer tempus enim ac faucibus mattis. Aliquam sed nibh quis sem tristique dictum. Morbi dapibus gravida lobortis. Nam consectetur metus id orci tempus iaculis. Curabitur semper tellus in lacus pharetra aliquam. Fusce scelerisque dictum turpis. Phasellus congue nulla sed egestas venenatis. Aliquam a consequat ipsum. Quisque semper vel arcu ac hendrerit.");
////        p.setTitle("Test Title 4");
////        p.setUserId(1);
////        p.setLastModifiedUserId(1);
////        p.setCreateDate(dtf.parse("2015-08-06"));
////        p.setLastModifiedDate(dtf.parse("2015-08-07"));
////        p.setExpDate(dtf.parse("2015-12-31"));
////        p.setPublished(1);
////        p.setPending(1);
////        p.setBlurb("Blurb");
////
////        p2 = new Post();
////        p2.setContent("Nam pulvinar nisl metus, et venenatis nulla molestie at. Sed purus neque, malesuada eu elit non, scelerisque commodo velit. Ut sollicitudin convallis lacinia. Morbi in feugiat ipsum. Donec vitae dolor vitae odio congue tempus. Pellentesque et semper dui. In lectus sem, lacinia in nunc vel, fringilla hendrerit sem. Interdum et malesuada fames ac ante ipsum primis in faucibus.");
////        p2.setTitle("Test Title 5");
////        p2.setUserId(1);
////        p2.setLastModifiedUserId(1);
////        p2.setCreateDate(dtf.parse("2012-12-12"));
////        p2.setLastModifiedDate(dtf.parse("2015-03-14"));
////        p2.setExpDate(dtf.parse("2015-12-31"));
////        p2.setPublished(1);
////        p2.setPending(1);
////        p2.setBlurb("Blurb5");
////
////    }
////    
////    @After
////    public void tearDown() {
////        
////       
////    }
////
////    /**
////     * Test of addPost method, of class PostImpl.
////     */
////    @Test
////    public void testAddGetDeletePost() throws ParseException {
////       
////        dao.addPost(p);
////        
////        Post fromDb = dao.viewPost(p.getPostId());
////        
////        Assert.assertEquals(fromDb, p);
////        
////        dao.deletePost(p.getPostId());
////        
////        Assert.assertNull(dao.viewPost(p.getPostId()));
////
////    }
////
////    /**
////     * Test of editPost method, of class PostImpl.
////     */
////    @Test
////    public void testAddEditDeletePost() throws ParseException {
////        
////        dao.addPost(p);
////        
////        p.setTitle("New Title");
////        dao.editPost(p);
////        
////        Post fromDb = dao.viewPost(p.getPostId());
////        
////        Assert.assertEquals(fromDb, p);
////        
////        dao.deletePost(p.getPostId());
////        
////        Assert.assertNull(dao.viewPost(p.getPostId()));
////        
////    }
////
////
////    /**
////     * Test of viewPost method, of class PostImpl.
////     */
////    @Test
////    public void testAddViewDeletePost() throws ParseException {
////        
////        dao.addPost(p);
////        
////        Post fromDb = dao.viewPost(p.getPostId());
////        
////        Assert.assertEquals(fromDb, p);
////        
////        dao.deletePost(p.getPostId());
////        
////        Assert.assertNull(dao.viewPost(p.getPostId()));
////        
////        
////    }
////
////    /**
////     * Test of viewAllPosts method, of class PostImpl.
////     */
////    @Test
////    public void testViewAllPosts() throws ParseException {
////        
////        
////        dao.addPost(p);
////        dao.addPost(p2);
////        
////        List<Post> pList = dao.viewAllPublishedPosts();
////        
////        Assert.assertEquals(4, pList.size());
////        
////        Assert.assertEquals(dao.viewPost(p.getPostId()), p);
////        
////        Assert.assertEquals(dao.viewPost(p2.getPostId()), p2);
////        
////        dao.deletePost(p2.getPostId());
////        
////        pList = dao.viewAllPublishedPosts();
////        
////        Assert.assertEquals(3, pList.size());
////        
////        Assert.assertNull(dao.viewPost(p2.getPostId()));
////        
////        dao.deletePost(p.getPostId());
////        
////        pList = dao.viewAllPublishedPosts();
////        
////        Assert.assertEquals(2, pList.size());
////        
////    }
////    
////}
//=======
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.swcguild.kfdmasteryproject.dao;
//
//import com.swcguild.kfdmasteryproject.model.Post;
//import com.swcguild.kfdmasteryproject.model.User;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.List;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.jdbc.core.JdbcTemplate;
//
///**
// *
// * @author apprentice
// */
//public class PostImplTest {
//
//    private PostInterface dao;
//    private SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
//    private static final String SQL_DELETE_POST = "DELETE FROM posts WHERE post_id >4";
//    ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
//
//    JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
//    Post p;
//    Post p2;
//    User u;
//
//    public PostImplTest() {
//
//    }
//
//    @Before
//    public void setUp() throws ParseException {
//        dao = ctx.getBean("pdao", PostInterface.class);
//
//        p = new Post();
//        p.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla diam tellus, efficitur vel ligula non, pretium pretium odio. Nulla fringilla sem vestibulum ipsum porta mollis. Integer tempus enim ac faucibus mattis. Aliquam sed nibh quis sem tristique dictum. Morbi dapibus gravida lobortis. Nam consectetur metus id orci tempus iaculis. Curabitur semper tellus in lacus pharetra aliquam. Fusce scelerisque dictum turpis. Phasellus congue nulla sed egestas venenatis. Aliquam a consequat ipsum. Quisque semper vel arcu ac hendrerit.");
//        p.setTitle("Test Title 4");
//        p.setUserId(1);
//        p.setLastModifiedUserId(1);
//        p.setCreateDate(dtf.parse("2015-08-06"));
//        p.setLastModifiedDate(dtf.parse("2015-08-07"));
//        p.setExpDate(dtf.parse("2015-12-31"));
//        p.setPublished(1);
//        p.setPending(1);
//        p.setBlurb("Blurb");
//
//        u = new User();
//        u.setUserName("test_user");
//        u.setPassword("abc123");
//        u.setRoleId(1);
//
//        dao.savePost(p, u);
//
//        
//    }
//
//    @After
//    public void tearDown() {
//        jdbcTemplate.execute(SQL_DELETE_POST);
//
//    }
//
//    /**
//     * Test of addPost method, of class PostImpl.
//     */
//    @Test
//    public void testAddViewDeletePost() throws ParseException {
//
//        Post fromDb = dao.viewPost(p.getPostId());
//
//        Assert.assertEquals(fromDb.getTitle(), p.getTitle());
//
//
//    }
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
//        dao.editPost(p, u);
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
//    public void testViewAllPosts() throws ParseException {
//        
//        p2 = new Post();
//        p2.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla diam tellus, efficitur vel ligula non, pretium pretium odio. Nulla fringilla sem vestibulum ipsum porta mollis. Integer tempus enim ac faucibus mattis. Aliquam sed nibh quis sem tristique dictum. Morbi dapibus gravida lobortis. Nam consectetur metus id orci tempus iaculis. Curabitur semper tellus in lacus pharetra aliquam. Fusce scelerisque dictum turpis. Phasellus congue nulla sed egestas venenatis. Aliquam a consequat ipsum. Quisque semper vel arcu ac hendrerit.");
//        p2.setTitle("Test Title 5");
//        p2.setUserId(1);
//        p2.setLastModifiedUserId(1);
//        p2.setCreateDate(dtf.parse("2012-12-12"));
//        p2.setLastModifiedDate(dtf.parse("2015-03-14"));
//        p2.setExpDate(dtf.parse("2015-12-31"));
//        p2.setPublished(1);
//        p2.setPending(1);
//        p2.setBlurb("Blurb");
//
//        
//
//        dao.savePost(p2, u);
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
//}
//>>>>>>> c62398546603d88e22e40b3206cc15c074216ac3
