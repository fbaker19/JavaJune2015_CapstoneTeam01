///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.swcguild.kfdmasteryproject.dao;
//
//import com.swcguild.kfdmasteryproject.model.Comment;
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
//public class CommentImplTest {
//    
//    private CommentInterface dao;
//    private SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
//    Comment c1;
//    Comment c2;
//    
//    public CommentImplTest() {
//    }
//    
//    @Before
//    public void setUp() throws ParseException {
//        
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
//        dao = ctx.getBean("com", CommentInterface.class);
//        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
//        jdbcTemplate.execute("DELETE FROM comments");
//        
//        c1 = new Comment();
//        c1.setComment("This is a comment");
//        c1.setPostId(1);
//        c1.setCreateDate(dtf.parse("2015-08-10"));
//        c1.setCommenter("Anonymous person");
//        c1.setPublished(1);
//        c1.setPending(0);
//        
//        c2 = new Comment();
//        c2.setComment("This is a second comment");
//        c2.setPostId(1);
//        c2.setCreateDate(dtf.parse("2015-08-11"));
//        c2.setCommenter("Stranger danger");
//        c2.setPublished(0);
//        c2.setPending(1);
//        
//        
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of viewComment method, of class CommentImpl.
//     */
//    @Test
//    public void testAddViewDeleteComment() {
//        
//        dao.addComment(c1);
//        
//        Comment fromDb = dao.viewComment(c1.getCommentId());
//        
//        Assert.assertEquals(fromDb, c1);
//        
//        dao.deleteComment(c1.getCommentId());
//        
//        Assert.assertNull(dao.viewComment(c1.getCommentId()));
//        
//    }
//
//    /**
//     * Test of viewAllComments method, of class CommentImpl.
//     */
//    @Test
//    public void testAddViewAllDeleteComments() {
//        
//        dao.addComment(c1);
//        dao.addComment(c2);
//        
//        List<Comment> commentList = dao.viewAllComments(1);
//        
//        Assert.assertEquals(2, commentList.size());
//        
//        Assert.assertEquals(dao.viewComment(c1.getCommentId()), c1);
//        Assert.assertEquals(dao.viewComment(c2.getCommentId()), c2);
//        
//        dao.deleteComment(c1.getCommentId());
//        
//        commentList = dao.viewAllComments(c1.getPostId());
//        
//        Assert.assertEquals(1, commentList.size());
//    }
//
//    /**
//     * Test of viewAllPendingComments method, of class CommentImpl.
//     */
//    @Test
//    public void testAddViewAllPendingDeleteComments() {
//        
//        dao.addComment(c1);
//        dao.addComment(c2);
//        
//        List<Comment> commentList = dao.viewAllPendingComments();
//        
//        Assert.assertEquals(1, commentList.size());
//        
//        Assert.assertEquals(dao.viewComment(c1.getCommentId()), c1);
//        Assert.assertEquals(dao.viewComment(c2.getCommentId()), c2);
//        
//        dao.deleteComment(c2.getCommentId());
//        
//        commentList = dao.viewAllPendingComments();
//        
//        Assert.assertEquals(0, commentList.size());
//        
//        
//    }
//
//    
//}
