/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproect.dao;

import com.swcguild.kfdmasteryproject.dao.CommentInterface;
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
        dao = ctx.getBean("" ,CommentInterface.class);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setJdbcTemplate method, of class CommentImpl.
     */
    @Test
    public void testSetJdbcTemplate() {
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
    public void testAddComment() {
    }

    /**
     * Test of deleteComment method, of class CommentImpl.
     */
    @Test
    public void testDeleteComment() {
    }
    
}
