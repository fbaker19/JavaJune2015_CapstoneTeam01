///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.swcguild.kfdmasteryproject.dao;
//
//import com.swcguild.kfdmasteryproject.dao.CategoryTagInterface;
//import com.swcguild.kfdmasteryproject.model.Category;
//import com.swcguild.kfdmasteryproject.model.Post;
//import com.swcguild.kfdmasteryproject.model.Tag;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import junit.framework.Assert;
//import org.junit.After;
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
//public class CategoryTagImplTest {
//
//    //import dao/interface
//    private CategoryTagInterface dao;
//    private PostInterface dao2;
//    private static final String SQL_DELETE_CATEGORY = "DELETE FROM categories";
//    private SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
//    ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
//    JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
//
//    Post p;
//    Category c;
//    Category c2;
//
//    public CategoryTagImplTest() {
//    }
//
//    @Before
//    public void setUp() throws ParseException {
//
//        //Import Beans 
//        dao = ctx.getBean("cat", CategoryTagInterface.class);
//        dao2 = ctx.getBean("pdao", PostInterface.class);
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
//        p.setPending(0);
//        p.setBlurb("Blurb");
//
//        c = new Category();
//        c2 = new Category();
//        c.setCategoryName("Events");
//        c2.setCategoryName("Fun Stuff");
//        dao.addCategory(c);
//        dao.addCategory(c2);
//        dao2.publishNewPost(p);
//    }
//
//    @After
//    public void tearDown() {
//        jdbcTemplate.execute(SQL_DELETE_CATEGORY);
//    }
//
//    /**
//     * Test of addCategory method, of class CategoryTagImpl.
//     */
//    @Test
//    public void testAddGetDeleteCategory() {
//
//        //get/view
//        Category result = dao.viewCategory(c.getCategoryId());
//        Assert.assertEquals(result, c);
//
//        //delete
//        dao.deleteCategory(c.getCategoryId());
//        Assert.assertNull(dao.viewCategory(c.getCategoryId()));
//
//    }
//
//    /**
//     * Test of editCategory method, of class CategoryTagImpl.
//     */
////    @Test
////    public void testAddEditDeleteCategory() {
////
////        Category c = new Category();
////
////        //SET
////        c.setCategoryName("Test category");
////        c.setCategoryId(1);
////
////        //TESTING
////        //add
////        dao.addCategory(c);
////
////        //Edit
////        c.setCategoryName("New Category Name");
////        dao.editCategory(c);
////
////        Category resultFromDb = dao.viewCategory(c.getCategoryId());
////        Assert.assertEquals(resultFromDb, c);
////
////        //Delete
////        dao.deleteCategory(c.getCategoryId());
////        Assert.assertNull(dao.viewCategory(c.getCategoryId()));
////
////    }
////
////    //CATEGORY/POST
////    @Test
////    public void testDeleteCategoryFromPost() {
////    }
////
//////    @Test  //GET in addGetDelete
//////    public void testViewCategory() {
//////    }
////    /**
////     * Test of viewPost method, of class CategoryTagImpl.
////     */
////    @Test
////    public void testAddViewDeletePostsByCategory() throws ParseException {
//////        Category c = new Category();
//////        
//////        //SET
//////        c.setCategoryId(1);
//////        c.setCategoryName("postCats");
//////       
//////        Post p = new Post();
//////        p.setContent("Test content");
//////        p.setTitle("Test Title 4");
//////        p.setUserId(1);
//////        p.setLastModifiedUserId(1);
//////        p.setCreateDate(dtf.parse("2015-08-06"));
//////        p.setLastModifiedDate(dtf.parse("2015-08-07"));
//////        p.setExpDate(dtf.parse("2015-12-31"));
//////        p.setPublished(1);
//////        p.setBlurb("Blurb");
//////
//////      
//////        dao2.addPost(p);
//////        
//////        Post fromDb = dao2.viewPost(c.getCategoryId());
//////        
//////        org.junit.Assert.assertEquals(fromDb, p);
//////        
//////        dao.deleteCategoryFromPost(c.getCategoryId());
//////        
//////        org.junit.Assert.assertNull(dao2.viewPost(p.getPostId()));
//////        
//////       
//////        
////    }
////
////    //TAGS
////    @Test
////    public void testAddGetTag() {
////        //set
////        Tag tag = new Tag();
////        tag.setTagId(1);
////        tag.setTagName("tag test");
////
////        //add
////        dao.addTag(tag);
////
////        //get
////        Tag resultFromDb = dao.viewTag(tag.getTagId());
////        Assert.assertEquals(resultFromDb, tag);
////
////    }
////
//////   @Test// 'Get' in addGet Tag
//////    public void testViewTag() {
//////    }
////    @Test
////    public void testViewPostsByTag() {
////        //set
////    }
//
//}
