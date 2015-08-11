/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.dao;

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

<<<<<<< HEAD
    private static final String SQL_INSERT_CATEGORY = "INSERT INTO categories (category_name)VALUES(?)";
=======
    private static final String SQL_SELECT_ALL_CATEGORIES = "SELECT * FROM categories";
    private static final String SQL_INSERT_CATEGORY = "INSERT INTO categories (category_name)Values(?)";
>>>>>>> bee40384cf71aa557a7428d747540dd5da104b63
    private static final String SQL_DELETE_CATEGORY = "DELETE FROM categories WHERE category_id =?";//delete from categories post as well
    private static final String SQL_DELETE_CATEGORY_FROM_POST = "DELETE FROM categories_posts WHERE category_id";
    private static final String SQL_UPDATE_CATEGORY = "UPDATE categories SET category_name = ? WHERE category_id = ?";
    private static final String SQL_SELECT_CATEGORY = "SELECT * FROM categories WHERE category_id = ?";
    private static final String SQL_SELECT_ALL_POST_BY_CATEGORY = "SELECT * FROM categories_posts";

    private static final String SQL_INSERT_TAG = "INSERT INTO tags (tag_name) VALUES (?) ";
    private static final String SQL_SELECT_TAG = "SELECT * FROM tags WHERE tag_id =?";
    private static final String SQL_SELECT_ALL_POSTS_WITH_TAG = "SELECT * FROM tag_post";
    
    

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Category addCategory(Category category) {
        jdbcTemplate.update(SQL_INSERT_CATEGORY,
                category.getCategoryName());
       
        category.setCategoryId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));

        return category;
    }

    @Override
    public void editCategory(Category category) {
        jdbcTemplate.update(SQL_UPDATE_CATEGORY,
                category.getCategoryName(),
                category.getCategoryId());
    }

    @Override
    public void deleteCategory(int categoryId) {
        jdbcTemplate.update(SQL_DELETE_CATEGORY, categoryId);
    }

      @Override
    public void deleteCategoryFromPost(int categoryId) {
        jdbcTemplate.update(SQL_DELETE_CATEGORY_FROM_POST, categoryId);
    }
    
    @Override
    public Category viewCategory(int categoryId) {
        try {                                                           //postMapper??
            return jdbcTemplate.queryForObject(SQL_SELECT_CATEGORY, new CategoryMapper(), categoryId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    @Override
    public List<Post> viewPostsByCategory(int categoryId) {
        return jdbcTemplate.query(SQL_SELECT_ALL_POST_BY_CATEGORY, new PostMapper(), categoryId);
    }
    
    @Override
    public List<Category> viewAllCategories(){
        return jdbcTemplate.query(SQL_SELECT_ALL_CATEGORIES, new CategoryMapper());
    }

    
    
    
    @Override
    public Tag addTag(Tag tag) {
        jdbcTemplate.update(SQL_INSERT_TAG,
                tag.getTagName());
        tag.setTagId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));

        return tag;
    }

    @Override
    public Tag viewTag(int tagId) {
        try {                                                   //postMapper??
            return jdbcTemplate.queryForObject(SQL_SELECT_TAG, new TagMapper(), tagId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override//all
    public List<Post> viewPostsByTag(int tagId) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return jdbcTemplate.query(SQL_SELECT_ALL_POSTS_WITH_TAG , new PostMapper(), tagId);
    }
    

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
    
    private static final class PostMapper implements ParameterizedRowMapper <Post> {

        @Override
        public Post mapRow(ResultSet rs, int i) throws SQLException {
            Post post = new Post();
           
            post.setBlurb(rs.getString("blurb"));
            post.setContent(rs.getString("content"));
            post.setCreateDate(rs.getDate("create_date"));
            post.setExpDate(rs.getDate("expiration_date"));
            post.setLastModifiedDate(rs.getDate("last_modified_date"));
            post.setLastModifiedUserId(rs.getInt("last_modified_user_id"));
            post.setPostId(rs.getInt("post_id"));
            post.setPublished(rs.getInt("published"));
            post.setTitle(rs.getString("title"));
            post.setUserId(rs.getInt("user_id"));
           
            return post;
        }

    }
}
