/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.dao;

import com.swcguild.kfdmasteryproject.model.Image;
import com.swcguild.kfdmasteryproject.model.Post;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.jsoup.Jsoup;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;


/**
 *
 * @author apprentice
 */
public class PostImpl implements PostInterface {

    private static final String SQL_SELECT_ALL_PUBLISHED_POSTS = "SELECT * FROM posts WHERE published=1 ORDER BY create_date DESC"; //make sure unpublished ones don't show up
    private static final String SQL_SELECT_POST = "SELECT * FROM posts WHERE post_id = ?";
    private static final String SQL_SELECT_LATEST_POST = "SELECT * FROM posts WHERE published=1 ORDER BY post_id DESC LIMIT 1";//make sure unpublished ones don't show up
    private static final String SQL_SELECT_ALL_PENDING_POSTS = "SELECT * FROM posts WHERE pending=1";
    
    
    //userid/foreign key????? post? catagory  deletion?
    private static final String SQL_INSERT_POST = "INSERT INTO posts (content, title, user_id, "
            + "last_modified_user_id, create_date, last_modified_date, expiration_date, published, pending, blurb, hashtag1, hashtag2, hashtag3, category_id)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    private static final String SQL_DELETE_POST = "DELETE FROM posts WHERE post_id = ?";
    private static final String SQL_UPDATE_POST = "UPDATE posts SET content = ?, title =?, user_id = ?, "
            + "last_modified_user_id = ?, create_date = ?, last_modified_date= ?, expiration_date = ?, published= ?, pending = ?, blurb= ? , hashtag1=?, hashtag2=?, hashtag3=?,  category_id=? WHERE post_id =?";
    
    private static final String SQL_SELECT_ALL_PUBLISHED_POSTS_BY_CATEGORY_ID = "SELECT * FROM posts WHERE published=1 AND category_id=?";
    //IMAGE
    private static final String SQL_INSERT_IMAGE = "INSERT INTO image (image) VALUES (?)";
    private static final String SQL_SELECT_IMAGE_BY_ID = "SELECT * FROM image WHERE image_id = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Post saveNewPost(Post post) {
        
        
            post.setCreateDate(new Date());
            post.setLastModifiedDate(new Date());
            post.setUserId(1);
            post.setLastModifiedUserId(1);
            post.setPending(1);
            post.setPublished(0);

            if (post.getContent().length()<500){
                post.setBlurb(post.getContent());
            } else {
            post.setBlurb(Jsoup.parse(post.getContent()).text().substring(0, 500));
            }
        
        jdbcTemplate.update(SQL_INSERT_POST,
                post.getContent(),
                post.getTitle(),
                post.getUserId(),
                post.getLastModifiedUserId(),
                post.getCreateDate(),
                post.getLastModifiedDate(),
                post.getExpDate(),
                post.getPublished(),
                post.getPending(),
                post.getBlurb(),
                post.getHashtag1(),
                post.getHashtag2(),
                post.getHashtag3(),
                post.getCategoryId());
       
        post.setPostId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
                
             return post;
        
    }
    
    
    

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Post publishNewPost(Post post) {
            post.setCreateDate(new Date());
            post.setUserId(1);
            post.setLastModifiedDate(new Date());
            post.setLastModifiedUserId(1);
            post.setPending(0);
            post.setPublished(1);
            
            if (post.getContent().length()<500){
                post.setBlurb(post.getContent());
            } else {
            post.setBlurb(Jsoup.parse(post.getContent()).text().substring(0, 500));
            }
           
        
        jdbcTemplate.update(SQL_INSERT_POST,
                post.getContent(),
                post.getTitle(),
                post.getUserId(),
                post.getLastModifiedUserId(),
                post.getCreateDate(),
                post.getLastModifiedDate(),
                post.getExpDate(),
                post.getPublished(),
                post.getPending(),
                post.getBlurb(),
                post.getHashtag1(),
                post.getHashtag2(),
                post.getHashtag3(),
                post.getCategoryId());
                
        post.setPostId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        return post;
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Post updatePost(Post post) {
       
            Post existingPost = viewPost(post.getPostId());
            post.setPostId(existingPost.getPostId());
            post.setUserId(existingPost.getUserId());
            post.setCreateDate(existingPost.getCreateDate());
            post.setLastModifiedDate(new Date());
            post.setLastModifiedUserId(2);
            
            if (post.getContent().length()<500){
                post.setBlurb(post.getContent());
            } else {
            post.setBlurb(Jsoup.parse(post.getContent()).text().substring(0, 500));
            }
        
        jdbcTemplate.update(SQL_UPDATE_POST,
                post.getContent(),
                post.getTitle(),
                post.getUserId(),
                post.getLastModifiedUserId(),
                post.getCreateDate(),
                post.getLastModifiedDate(),
                post.getExpDate(),
                post.getPublished(),
                post.getPending(),
                post.getBlurb(),
                post.getHashtag1(),
                post.getHashtag2(),
                post.getHashtag3(),
                post.getCategoryId(),
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
            Post post = jdbcTemplate.queryForObject(SQL_SELECT_POST, new PostMapper(), postId);
            //return jdbcTemplate.queryForObject(SQL_SELECT_POST, new PostMapper(), postId);
            return post;
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

     public void expirePosts(){
         Date date = new Date();
         List <Post> exPosts = jdbcTemplate.query(SQL_SELECT_ALL_PUBLISHED_POSTS, new PostMapper());
         for (Post post : exPosts){
             if ((post.getExpDate() != null) && date.after(post.getExpDate())){
                 post.setPublished(0);
             }
         }
     }


    @Override
    public List<Post> viewAllPublishedPosts() {
        expirePosts();
        return jdbcTemplate.query(SQL_SELECT_ALL_PUBLISHED_POSTS, new PostMapper());
    }
    
    @Override
    public List<Post> viewAllPublishedPostsByCategoryId(int categoryId){
        expirePosts();
        return jdbcTemplate.query(SQL_SELECT_ALL_PUBLISHED_POSTS_BY_CATEGORY_ID, new PostMapper(), categoryId);
    
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Image addImage(Image image) {
        jdbcTemplate.update(SQL_INSERT_IMAGE, image.getImage());
        image.setImage_id(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        return image;
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Image getImage(int id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_IMAGE_BY_ID, new ImageMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    private static final class PostMapper implements ParameterizedRowMapper<Post> {

        @Override
        public Post mapRow(ResultSet rs, int i) throws SQLException {
            Post post = new Post();
            post.setBlurb(rs.getString("blurb"));
            post.setContent(rs.getString("content"));
            post.setCreateDate(rs.getTimestamp("create_date"));
            post.setExpDate(rs.getDate("expiration_date"));
            post.setLastModifiedDate(rs.getTimestamp("last_modified_date"));
            post.setLastModifiedUserId(rs.getInt("last_modified_user_id"));
            post.setPostId(rs.getInt("post_id"));
            post.setPublished(rs.getInt("published"));
            post.setPending(rs.getInt("pending"));
            post.setTitle(rs.getString("title"));
            post.setUserId(rs.getInt("user_id"));
            post.setCategoryId(rs.getInt("category_id"));
            post.setHashtag1(rs.getString("hashtag1"));
            post.setHashtag2(rs.getString("hashtag2"));
            post.setHashtag3(rs.getString("hashtag3"));

            return post;

        }

    }
    private static final class ImageMapper implements ParameterizedRowMapper<Image> {

        @Override
        public Image mapRow(ResultSet rs, int i) throws SQLException {
            Image image = new Image();
            image.setImage_id(rs.getInt("image_id"));
            image.setImage(rs.getBytes("image"));
            return image;
        }
       
    }

}
