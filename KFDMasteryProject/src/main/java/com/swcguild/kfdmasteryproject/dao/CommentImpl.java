/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.dao;

import com.swcguild.kfdmasteryproject.model.Comment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
public class CommentImpl implements CommentInterface {
   
    private static final String SQL_INSERT_COMMENT ="INSERT INTO comments (comment, post_id, create_date, commenter, published, pending) VALUES(?,?,?,?,?,?)";
    private static final String SQL_DELETE_COMMENT ="DELETE FROM comments WHERE comment_id = ?";
    private static final String SQL_SELECT_ALL_COMMENTS = "SELECT * FROM comments WHERE post_id = ?";
    private static final String SQL_SELECT_ALL_PENDING_COMMENTS = "SELECT * FROM comments WHERE pending=1";
    private static final String SQL_SELECT_COMMENT = "SELECT * FROM comments WHERE comment_id = ?";
    private static final String SQL_UPDATE_COMMENT ="UPDATE comments SET comment=?, post_id=?, create_date=?, commenter=?, published=?, pending=? WHERE comment_id =?";
  
    
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly =false)
    public Comment viewComment(int commentId) {
       try{
          return jdbcTemplate.queryForObject(SQL_SELECT_COMMENT, new CommentMapper(), commentId);
       }catch(EmptyResultDataAccessException ex){
           return null;
       }
    }

    @Override
    public List<Comment> viewAllComments(int postId) {
        return jdbcTemplate.query(SQL_SELECT_ALL_COMMENTS, new CommentMapper(), postId);
    }
    
    @Override
    public List<Comment> viewAllPendingComments(){
        return jdbcTemplate.query(SQL_SELECT_ALL_PENDING_COMMENTS, new CommentMapper());
    }

    @Override
    public Comment addComment(Comment comment) {
        
        comment.setCreateDate(new Date());
        
         jdbcTemplate.update(SQL_INSERT_COMMENT,
                comment.getComment(),
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenter(),
                comment.getPublished(),
                comment.getPending()
                );
         
         comment.setCommentId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
         return comment;
         
    }
    
    @Override
    public Comment updateComment(Comment comment){
        
        jdbcTemplate.update(SQL_UPDATE_COMMENT,
                comment.getComment(),
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenter(),
                comment.getPublished(),
                comment.getPending(),
                comment.getCommentId());
        
        return comment;
    }

    @Override
    public void deleteComment(int commentId) {
        jdbcTemplate.update(SQL_DELETE_COMMENT, commentId);
    }
    
    
    private static final class CommentMapper implements ParameterizedRowMapper<Comment>
    {

        @Override
        public Comment mapRow(ResultSet rs, int i) throws SQLException {
            
            Comment comment = new Comment();    
            comment.setCommentId(rs.getInt("comment_id"));
            comment.setComment(rs.getString("comment"));
            comment.setPostId(rs.getInt("post_id"));
            comment.setCreateDate(rs.getDate("create_date"));
            comment.setCommenter(rs.getString("commenter"));
            comment.setPublished(rs.getInt("published"));
            comment.setPending(rs.getInt("pending"));           
            return comment;
        }
    
    } 
}
