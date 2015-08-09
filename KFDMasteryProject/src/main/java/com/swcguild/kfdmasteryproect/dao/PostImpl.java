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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

/**
 *
 * @author apprentice
 */
public class PostImpl implements PostInterface {

    private static final String SQL_SELECT_ALL_POSTS = "SELECT * FROM posts ORDER BY post_id DESC";
    private static final String SQL_SELECT_POST = "SELECT * FROM posts WHERE post_id = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Post addPost(Post post) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Post editPost(Post post) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePost(int postId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
