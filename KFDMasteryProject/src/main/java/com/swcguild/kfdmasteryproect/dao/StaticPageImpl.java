/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproect.dao;

import com.swcguild.kfdmasteryproject.model.Post;
import com.swcguild.kfdmasteryproject.model.StaticPage;
<<<<<<< HEAD
import org.springframework.jdbc.core.JdbcTemplate;
=======
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

>>>>>>> 9d0707add898daa97040302b9eed4227dd3c75d1

/**
 *
 * @author apprentice
 */
public class StaticPageImpl implements StaticPageInterface {
    
<<<<<<< HEAD
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
=======

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
>>>>>>> 9d0707add898daa97040302b9eed4227dd3c75d1
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public StaticPage addContent(StaticPage staticPage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StaticPage editContent(StaticPage staticPage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
   public StaticPage viewContent(StaticPage staticPage) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }
    

    @Override
    public void deleteContent(int pageId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
