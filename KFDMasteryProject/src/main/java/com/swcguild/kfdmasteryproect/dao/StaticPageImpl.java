/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproect.dao;

import com.swcguild.kfdmasteryproject.model.StaticPage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class StaticPageImpl implements StaticPageInterface {

    private static final String SQL_INSERT_STATIC_PAGE = "INSERT INTO static_pages (content, title, date, user_id) VALUES(?,?,?,?)";
    private static final String SQL_DELETE_STATIC_PAGE = "DELETE FROM static_pages WHERE page_id = ?";
    private static final String SQL_UPDATE_STATIC_PAGE = "UPDATE static_pages SET content = ?, title = ?, date = ?, user_id = ? WHERE page_id =?";
    private static final String SQL_SELECT_STATIC_PAGE = "SELECT * FROM static_pages WHERE page_id=?";
    private static final String SQL_SELECT_ALL_STATIC_PAGE = "SELECT * FROM static_pages";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public StaticPage addContent(StaticPage staticPage) {
        jdbcTemplate.update(SQL_INSERT_STATIC_PAGE,
                staticPage.getContent(),
                staticPage.getTitle(),
                staticPage.getDate(),
                staticPage.getUserId());

        staticPage.setPageId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));

        return staticPage;
    }

    @Override
    public void editContent(StaticPage staticPage) {
        jdbcTemplate.update(SQL_UPDATE_STATIC_PAGE,
                staticPage.getContent(),
                staticPage.getTitle(),
                staticPage.getDate(),
                staticPage.getUserId(),
                staticPage.getPageId());
    }

    @Override///int page Id as the parameter?
    //why does 'view' need a mapper?
    public StaticPage viewContentById(int pageId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_STATIC_PAGE, new StaticMapper(), pageId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    @Override
    public List<StaticPage> viewAllContent (){
        return jdbcTemplate.query(SQL_SELECT_ALL_STATIC_PAGE, new StaticMapper());
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
            sp.setTitle(rs.getString("title"));
            sp.setUserId(rs.getInt("user_id"));

            return sp;
        }
    }

}
