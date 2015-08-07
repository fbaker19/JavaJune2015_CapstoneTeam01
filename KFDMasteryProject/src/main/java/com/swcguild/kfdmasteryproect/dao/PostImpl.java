/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproect.dao;

import com.swcguild.kfdmasteryproject.model.Post;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
<<<<<<< HEAD
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
=======
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
>>>>>>> 9d0707add898daa97040302b9eed4227dd3c75d1

/**
 *
 * @author apprentice
 */
public class PostImpl implements PostInterface {

<<<<<<< HEAD
    //userid/foreign key?????
    private static final String SQL_INSERT_POST = "INSERT INTO posts (content, title, last_modified_user_id, create_date, last_modified date, exp_date, published)VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_DELETE_POST = "DELETE FROM posts WHERE post_id = ?";
    private static final String SQL_UPDATE_POST = "UPDATE posts SET............................. WHERE post_id =?";
    private static final String SQL_SELECT_POST = "SELECT * FROM posts WHERE post_id=?";
    private static final String SQL_SELECT_ALL_POST = "SELECT * FROM posts";
=======
    private static final String SQL_SELECT_ALL_POSTS = "SELECT * FROM posts";
    private static final String SQL_SELECT_POST = "SELECT * FROM posts WHERE post_id = ?";
>>>>>>> 9d0707add898daa97040302b9eed4227dd3c75d1

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
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_POST, new PostMapper(), postId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Post> viewAllPosts() {
<<<<<<< HEAD
        return jdbcTemplate.query(SQL_SELECT_ALL_POST, new PostMapper());
    }

=======
        return jdbcTemplate.query(SQL_SELECT_ALL_POSTS, new PostMapper());

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
            post.setTitle(rs.getString("title"));
            post.setUserId(rs.getInt("user_id"));

            return post;

        }

    }
>>>>>>> 9d0707add898daa97040302b9eed4227dd3c75d1
}
