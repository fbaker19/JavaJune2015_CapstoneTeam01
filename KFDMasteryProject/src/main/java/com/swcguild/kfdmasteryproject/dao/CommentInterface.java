/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.dao;

import com.swcguild.kfdmasteryproject.model.Comment;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface CommentInterface {
    
    public Comment viewComment(int commentId);
    
    public List<Comment> viewAllPublishedComments(int postId);
    
    public Comment addComment(Comment comment);
    
    public void deleteComment (int commentId);
    
    public List<Comment> viewAllPendingComments();
    
    public int numberOfComments (int postId);
    
    public Comment updateComment(Comment comment);
       
}
