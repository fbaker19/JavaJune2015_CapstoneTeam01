/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproect.dao;

import com.swcguild.kfdmasteryproject.dao.CommentInterface;
import com.swcguild.kfdmasteryproject.model.Comment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class CommentImplTest {
    
    private CommentInterface dao;
    private SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
    
    public CommentImplTest() {
    }
    
    @Before
    public void setUp() {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("comment" ,CommentInterface.class);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of viewComment method, of class CommentImpl.
     */
    @Test
    public void testViewComment() {
    }

    /**
     * Test of viewAllComments method, of class CommentImpl.
     */
    @Test
    public void testViewAllComments() {
    }

    /**
     * Test of addComment method, of class CommentImpl.
     */
    @Test
    public void testAddViewDeleteComment() throws ParseException {
        
//        Comment c = new Comment();
//        
//        c.setComment("Comment text");
//        c.setPostId(1);
//        c.setCommentDate(dtf.parse("2015-08-08"));
        
        
    }

    /**
     * Test of deleteComment method, of class CommentImpl.
     */
    @Test
    public void testDeleteComment() {
    }
    
}
