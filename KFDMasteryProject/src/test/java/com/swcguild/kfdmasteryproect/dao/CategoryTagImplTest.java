/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproect.dao;

import com.swcguild.kfdmasteryproject.dao.CategoryTagInterface;
import com.swcguild.kfdmasteryproject.model.Category;
import com.swcguild.kfdmasteryproject.model.Tag;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class CategoryTagImplTest {
    
    //import dao/interface
    private CategoryTagInterface dao;
    
    public CategoryTagImplTest() {
    }
    
    @Before
    public void setUp() {
        //link to xml test file(indentical to spring-persistance)
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        
        //Import Beans 
        dao = ctx.getBean("categoryTag", CategoryTagInterface.class);
        JdbcTemplate jdbcTemplate =(JdbcTemplate) ctx.getBean("jdbcTemplate");
    }
    
    @After
    public void tearDown() {
    }

   

    @Test
    public void testAddGetDeleteCategory() {
        Category c = new Category();
        
        //SET
        c.setCategoryName("Test  category");
        c.setCategoryId(1);
        
        //TESTING
        //add
        dao.addCategory(c);
        
        //get/view
        Category result = dao.viewCategory(c.getCategoryId());
        Assert.assertEquals(result, c);
        
        //delete
        dao.deleteCategory(c.getCategoryId());
        Assert.assertNull(dao.viewCategory(c.getCategoryId()));
        
    }

    @Test
    public void testAddEditCategory() {
        
        
    }

   

    
    
    @Test
    public void testDeleteCategoryFromPost() {
    }

//    @Test  //GET in addGetDelete
//    public void testViewCategory() {
//    }

    @Test
    public void testViewPostsByCategory() {
    }
    
    
    
    
    
    
    @Test
    public void testAddGetTag() {
        //set
        Tag tag = new Tag();
        tag.setTagId(1);
        tag.setTagName("tag test");
        
        //add
        dao.addTag(tag);
        
        
        //get
        Tag resultFromDb = dao.viewTag(tag.getTagId());
        Assert.assertEquals(resultFromDb, tag);
        
        
        
        
    }

////    @Test// 'Get' in addGet Tag
//    public void testViewTag() {
//    }

    @Test
    public void testViewPostsByTag() {
    }
    
}
