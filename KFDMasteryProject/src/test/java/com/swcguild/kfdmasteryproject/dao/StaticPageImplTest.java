<<<<<<< HEAD
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.swcguild.kfdmasteryproject.dao;
//
//import com.swcguild.kfdmasteryproject.dao.StaticPageInterface;
//import com.swcguild.kfdmasteryproject.model.StaticPage;
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
//public class StaticPageImplTest {
//    
//    private StaticPageInterface dao;
//    private SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
//
//    StaticPage s;
//    StaticPage s2;
//    public StaticPageImplTest() {
//    }
//    
//    @Before
//    public void setUp() throws ParseException {
//
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
//        
//        dao = ctx.getBean("sp", StaticPageInterface.class);
//        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
//
//        //jdbcTemplate.execute("DELETE FROM static_pages");
//        
//        s = new StaticPage();
//        s.setContent("Content");
//        s.setDate(dtf.parse("2015-08-08"));
//        s.setTitle("Static Page Title");
//        s.setPublished(1);
//        s.setUserId(1);
//        
//        s2 = new StaticPage();
//        s2.setContent("Content");
//        s2.setDate(dtf.parse("2015-08-08"));
//        s2.setTitle("Static Page Title");
//        s2.setPublished(1);
//        s2.setUserId(1);
//
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of addContent method, of class StaticPageImpl.
//     */
//    @Test
//    public void testAddGetDeleteContent() throws ParseException {
//       
//        
//        dao.addContent(s);
//        
//        StaticPage fromDb = dao.viewContentById(s.getPageId());
//        
//        Assert.assertEquals(fromDb, s);
//        
//        dao.deleteContent(s.getPageId());
//        
//        Assert.assertNull(dao.viewContentById(s.getPageId()));
//        
//        
//    }
//
//    /**
//     * Test of editContent method, of class StaticPageImpl.
//     */
//    @Test
//    public void testAddEditDeleteContent() throws ParseException {
//  
//        
//        dao.addContent(s);
//        
//        s.setTitle("New Title");
//        dao.editContent(s);
//        
//        StaticPage fromDb = dao.viewContentById(s.getPageId());
//        
//        Assert.assertEquals(fromDb, s);
//        
//        dao.deleteContent(s.getPageId());
//        
//        Assert.assertNull(dao.viewContentById(s.getPageId()));
//        
//        
//    }
//
//    /**
//     * Test of viewContentById method, of class StaticPageImpl.
//     */
//    @Test
//    public void testAddViewByIdDeleteContent() throws ParseException {
//
//
//        dao.addContent(s);
//        
//        StaticPage fromDb1 = dao.viewContentById(s.getPageId());
//        
//        Assert.assertEquals(fromDb1, s);
//        Assert.assertEquals(fromDb1.getTitle(), s.getTitle());
//        
//        dao.deleteContent(s.getPageId());
//      
//        Assert.assertNull(dao.viewContentById(s.getPageId()));
//
//    }
//    
//    /**
//     * Test of viewAllContent method, of class StaticPageImpl.
//     */
//    @Test
//    public void testAddViewAllDeleteContent() throws ParseException {
//
//
//        dao.addContent(s);
//        dao.addContent(s2);
//        
//        List<StaticPage> sList = dao.viewAllContent();
//        
//        Assert.assertEquals(2, sList.size());
//        Assert.assertEquals(sList.get(0).getTitle(), s.getTitle());
//        
//        dao.deleteContent(s.getPageId());
//        dao.deleteContent(s2.getPageId());
//        
//        Assert.assertEquals(0, dao.viewAllContent().size());
//        Assert.assertNull(dao.viewContentById(s.getPageId()));
//        Assert.assertNull(dao.viewContentById(s2.getPageId()));
//
//    }
//}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.dao;

import com.swcguild.kfdmasteryproject.dao.StaticPageInterface;
import com.swcguild.kfdmasteryproject.model.StaticPage;
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
public class StaticPageImplTest {

    private StaticPageInterface dao;
    private SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
    ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
    JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
    StaticPage s;
    StaticPage s2;

    public StaticPageImplTest() {
    }

    @Before
    public void setUp() throws ParseException {

        dao = ctx.getBean("sp", StaticPageInterface.class);

       
        s = new StaticPage();
        s.setContent("Content");
        s.setDate(dtf.parse("2015-08-08"));
        s.setTitle("Static Page Title");
        s.setPublished(1);
        s.setUserId(1);

        s2 = new StaticPage();
        s2.setContent("Content");
        s2.setDate(dtf.parse("2015-08-08"));
        s2.setTitle("Static Page Title");
        s2.setPublished(1);
        s2.setUserId(1);

    }

    @After
    public void tearDown() {
        jdbcTemplate.execute("DELETE FROM static_pages");
    }

    /**
     * Test of addContent method, of class StaticPageImpl.
     */
    @Test
    public void testAddGetDeleteContent() throws ParseException {

        dao.addContent(s);

        StaticPage fromDb = dao.viewContentById(s.getPageId());

        Assert.assertEquals(fromDb, s);

        dao.deleteContent(s.getPageId());

        Assert.assertNull(dao.viewContentById(s.getPageId()));

    }

    /**
     * Test of editContent method, of class StaticPageImpl.
     */
    @Test
    public void testAddEditContent() throws ParseException {

        dao.addContent(s);

        s.setTitle("New Title");
        dao.editContent(s);

        StaticPage fromDb = dao.viewContentById(s.getPageId());

        Assert.assertEquals(fromDb, s);

    }

    /**
     * Test of viewContentById method, of class StaticPageImpl.
     */
    @Test
    public void testAddViewByIdContent() throws ParseException {

        dao.addContent(s);

        StaticPage fromDb1 = dao.viewContentById(s.getPageId());

        Assert.assertEquals(fromDb1, s);
        Assert.assertEquals(fromDb1.getTitle(), s.getTitle());

    }

    /**
     * Test of viewAllContent method, of class StaticPageImpl.
     */
    @Test
    public void testAddViewAllContent() throws ParseException {

        dao.addContent(s);
        dao.addContent(s2);

        List<StaticPage> sList = dao.viewAllContent();

        Assert.assertEquals(2, sList.size());
        Assert.assertEquals(sList.get(0).getTitle(), s.getTitle());

    }
}
>>>>>>> c62398546603d88e22e40b3206cc15c074216ac3
