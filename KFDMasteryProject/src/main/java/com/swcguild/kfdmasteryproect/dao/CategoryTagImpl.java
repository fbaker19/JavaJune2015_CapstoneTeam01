/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproect.dao;

import com.swcguild.kfdmasteryproject.model.Category;
import com.swcguild.kfdmasteryproject.model.Post;
import com.swcguild.kfdmasteryproject.model.Tag;
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
public class CategoryTagImpl implements CategoryTagInterface {

    private static final String SQL_INSERT_CATEGORY = "";
    private static final String SQL_DELETE_CATEGORY = "DELETE FROM categories";//delete from categories post as  well
    private static final String SQL_UPDATE_CATEGORY = "";
    private static final String SQL_SELECT_CATEGORY = "";
    private static final String SQL_SELECT_ALL_POST_BY_CATEGORY = "";

    private static final String SQL_INSERT_TAG = "";
    private static final String SQL_SELECT_TAG = "";
    private static final String SQL_SELECT_ALL_POSTS_WITH_TAG = "";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Category addCategory(Category category) {
        jdbcTemplate.update(SQL_INSERT_CATEGORY,
                category.getCategoryName());
        category.setCategoryId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));

        return category;
    }

    @Override
    public void editCategory(Category category) {
        jdbcTemplate.update(SQL_UPDATE_CATEGORY,
                category.getCategoryId(),
                category.getCategoryId());
    }

    @Override
    public void deleteCategory(int categoryId) {
        jdbcTemplate.update(SQL_DELETE_CATEGORY, categoryId);
    }

    @Override
    public Category viewCategory(int categoryId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_CATEGORY, new CategoryMapper(), categoryId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    @Override//link to postImpl?
    public List<Post> viewPostsByCategory(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet.");
        //return jdbcTemplate.query(SQL_SELECT_ALL_POST_BY_CATEGORY, new CategoryMapper(), categoryId);
    }

    /*
     Library MVC example
    
     @Override
     public List<Author> getAuthorsByBookId(int bookId) {
     return jdbcTemplate.query(SQL_SELECT_AUTHORS_BY_BOOK_ID, new AuthorMapper(), bookId);
     }
    
     <Author> new AuthorMapper(), ------ <post> & <postMapper>??
     should we we combine this(catTagImpl) with postimple and dto's on 1 = CatTagPostImpl?? 
    
     */
    @Override
    public Tag addTag(Tag tag) {
        jdbcTemplate.update(SQL_INSERT_TAG,
                tag.getTagName());
        tag.setTagId(jdbcTemplate.queryForObject("SELECT INSERT_LAST_ID()", Integer.class));

        return tag;
    }

    @Override
    public Tag viewTag(int tagId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_TAG, new TagMapper(), tagId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override//all
    public List<Post> viewPostsByTag(int tagId) {
        throw new UnsupportedOperationException("Not supported yet.");
        //return jdbcTemplate.query(SQL_SELECT_ALL_POSTS_WITH_TAG , new TagMapper(), tagId);
    }
    
    
    //SAME ISSUE ABOVE  WITH CATEGORY
     /*
     Library MVC example
    
     @Override
     public List<Author> getAuthorsByBookId(int bookId) {
     return jdbcTemplate.query(SQL_SELECT_AUTHORS_BY_BOOK_ID, new AuthorMapper(), bookId);
     }
    
     <Author> new AuthorMapper(), ------ <post> & <postMapper>??
     should we we combine this(catTagImpl) with postimple and dto's on 1 = CatTagPostImpl?? 
    
     */
    
    
    
    

    private static final class CategoryMapper implements ParameterizedRowMapper<Category> {

        @Override
        public Category mapRow(ResultSet rs, int i) throws SQLException {
            Category category = new Category();

            category.setCategoryId(rs.getInt("category_id"));
            category.setCategoryName(rs.getString("category_name"));

            return category;
        }

    }

    private static final class TagMapper implements ParameterizedRowMapper<Tag> {

        @Override
        public Tag mapRow(ResultSet rs, int i) throws SQLException {
            Tag tag = new Tag();
            tag.setTagId(rs.getInt("tag_id"));
            tag.setTagName(rs.getString("tag_name"));

            return tag;
        }

    }
}
