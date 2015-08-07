/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproect.dao;

import com.swcguild.kfdmasteryproject.model.Post;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class PostImpl implements PostInterface {

    //userid/foreign key?????
    private static final String SQL_INSERT_POST = "INSERT INTO posts (content, title, last_modified_user_id, create_date, last_modified date, exp_date, published)VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_DELETE_POST = "DELETE FROM posts WHERE post_id = ?";
    private static final String SQL_UPDATE_POST = "UPDATE posts SET............................. WHERE post_id =?";
    private static final String SQL_SELECT_POST = "SELECT * FROM posts WHERE post_id=?";
    private static final String SQL_SELECT_ALL_POST = "SELECT * FROM posts";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Post addPost(Post post) {
        jdbcTemplate.update(SQL_INSERT_POST,
                post.getContent(),
                post.getTitle(),
                //???post.getUserId(),
                post.getLastModifiedUserId(),
                post.getCreateDate(),
                post.getLastModifiedDate(),
                post.getExpDate(),
                post.isPublished());
       
        post.setPostId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
                
             return post;
        
    }

    @Override
    public Post editPost(Post post) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePost(int postId) {
        jdbcTemplate.update(SQL_DELETE_POST, postId );
    }

    @Override
    public Post viewPost(int postId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> viewAllPosts() {
        return jdbcTemplate.query(SQL_SELECT_ALL_POST, new PostMapper());
    }

}
