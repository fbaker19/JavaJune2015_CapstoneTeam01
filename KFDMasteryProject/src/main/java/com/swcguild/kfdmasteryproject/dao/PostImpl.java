/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.dao;

import com.swcguild.kfdmasteryproject.model.Post;
import com.swcguild.kfdmasteryproject.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.web.bind.annotation.RequestBody;


/**
 *
 * @author apprentice
 */
public class PostImpl implements PostInterface {

    private static final String SQL_SELECT_ALL_PUBLISHED_POSTS = "SELECT * FROM posts WHERE published=1 ORDER BY create_date DESC"; //make sure unpublished ones don't show up
    private static final String SQL_SELECT_POST = "SELECT * FROM posts WHERE post_id = ?";
    private static final String SQL_SELECT_LATEST_POST = "SELECT * FROM posts ORDER BY create_date DESC LIMIT 1";//make sure unpublished ones don't show up
    private static final String SQL_SELECT_ALL_PENDING_POSTS = "SELECT * FROM posts WHERE pending=1";
    
    
    //userid/foreign key????? post? catagory  deletion?
    private static final String SQL_INSERT_POST = "INSERT INTO posts (content, title, user_id, "
            + "last_modified_user_id, create_date, last_modified_date, expiration_date, published, pending, blurb)VALUES(?,?,?,?,?,?,?,?,?,?)";
    
    private static final String SQL_DELETE_POST = "DELETE FROM posts WHERE post_id = ?";
    private static final String SQL_UPDATE_POST = "UPDATE posts SET content = ?, title =?, user_id = ?, "
            + "last_modified_user_id = ?, create_date = ?, last_modified_date= ?, expiration_date = ?, published= ?, pending = ?, blurb= ? WHERE post_id =?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Post savePost(Post post) {
        
            post.setCreateDate(new Date());
            post.setLastModifiedDate(new Date());
            post.setUserId(1);
            post.setLastModifiedUserId(1);
            post.setPending(1);
            post.setPublished(0);
            post.setBlurb(post.getContent().substring(0, 500));
        
        jdbcTemplate.update(SQL_INSERT_POST,
                post.getContent(),
                post.getTitle(),
                post.getUserId(),
                post.getLastModifiedUserId(),
                post.getCreateDate(),
                post.getLastModifiedDate(),
                post.getExpDate(),
                post.isPublished(),
                post.isPending(),
                post.getBlurb());
       
        post.setPostId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
                
             return post;
        
    }
    

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Post publishPost(Post post) {
        
            if (post.getPostId()==null){
            post.setCreateDate(new Date());
            post.setUserId(1);
            post.setBlurb(post.getContent().substring(0, 500));
            post.setPostId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
            } else{
            
            Post existingPost = viewPost(post.getPostId());
            post.setPostId(existingPost.getPostId());
            post.setUserId(existingPost.getUserId());
            post.setCreateDate(existingPost.getCreateDate());
            post.setLastModifiedDate(new Date());
            post.setLastModifiedUserId(2);
            post.setPending(0);
            post.setPublished(1);}
        
        
        jdbcTemplate.update(SQL_UPDATE_POST,
                post.getContent(),
                post.getTitle(),
                post.getUserId(),
                post.getLastModifiedUserId(),
                post.getCreateDate(),
                post.getLastModifiedDate(),
                post.getExpDate(),
                post.isPublished(),
                post.isPending(),
                post.getBlurb(),
                post.getPostId());
        
        return post;
    }

    @Override
    public void deletePost(int postId) {
        jdbcTemplate.update(SQL_DELETE_POST, postId );
    }

    @Override
    public Post viewPost(int postId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_POST, new PostMapper(), postId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    @Override
     public Post viewLatestPost() {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_LATEST_POST, new PostMapper());
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
     
    @Override
     public List<Post> viewAllPendingPosts(){
         return jdbcTemplate.query(SQL_SELECT_ALL_PENDING_POSTS, new PostMapper());
     }


    @Override
    public List<Post> viewAllPublishedPosts() {

        return jdbcTemplate.query(SQL_SELECT_ALL_PUBLISHED_POSTS, new PostMapper());
    
    }

    private static final class PostMapper implements ParameterizedRowMapper<Post> {

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
            post.setPending(rs.getInt("pending"));
            post.setTitle(rs.getString("title"));
            post.setUserId(rs.getInt("user_id"));

            return post;

        }

    }

}
