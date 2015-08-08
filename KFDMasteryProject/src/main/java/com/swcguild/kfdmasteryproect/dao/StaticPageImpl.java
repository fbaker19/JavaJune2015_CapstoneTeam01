/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproect.dao;

import com.swcguild.kfdmasteryproject.model.StaticPage;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author apprentice
 */
public class StaticPageImpl implements StaticPageInterface {
    
    private static final String SQL_INSERT_STATIC_PAGE = "INSERT INTO static_pages (content, date) VALUES(?,?)";
    private static final String SQL_DELETE_STATIC_PAGE = "DELETE FROM static_pages WHERE page_id = ?";
    private static final String SQL_UPDATE_STATIC_PAGE = "UPDATE static_pages SET content = ?, date = ? WHERE page_id =?";
    private static final String SQL_SELECT_STATIC_PAGE = "SELECT * FROM static_pages WHERE page_id=?";
   // private static final String SQL_SELECT_ALL_STATIC_PAGE = "SELECT * FROM static_pages";
    

    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {

        this.jdbcTemplate = jdbcTemplate;
    }

   @Override
   @Transactional(propagation =Propagation.REQUIRED, readOnly =false)
    public StaticPage addContent(StaticPage staticPage) {
        jdbcTemplate.update(SQL_INSERT_STATIC_PAGE,
               
                staticPage.getContent(),
                staticPage.getDate());
        
        staticPage.setPageId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
               
        return staticPage;
    }

    @Override
    public void editContent(StaticPage staticPage) {
        jdbcTemplate.update(SQL_UPDATE_STATIC_PAGE,
                staticPage.getContent(),
                staticPage.getDate(),
                staticPage.getPageId());          
    }

    @Override///int page Id as the parameter?
   public StaticPage viewContent(StaticPage staticPage) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }
    
    @Override
    public void deleteContent(int pageId) {
        jdbcTemplate.update(SQL_DELETE_STATIC_PAGE, pageId);
    }
    
    
    private static final class StaticMapper implements ParameterizedRowMapper<StaticPage> {

        @Override
        public StaticPage mapRow(ResultSet rs, int i) throws SQLException {
            StaticPage sp = new StaticPage();
            
            sp.setPageId(rs.getInt("page_id"));
            sp.setContent(rs.getString("content"));
            sp.setDate(rs.getDate("date"));
           
            return sp;
        }
    
    
    } 
     
}
