/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.model;

import java.util.Date;
import java.util.Objects;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class Comment {
    private int commentId;
    
    @NotEmpty(message="Comment cannot be empty")
    private String comment;
    private int postId;
    private Date createDate;
    private String commenter;
    private int published;
    private int pending;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public int getPending() {
        return pending;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.commentId;
        hash = 79 * hash + Objects.hashCode(this.comment);
        hash = 79 * hash + this.postId;
        hash = 79 * hash + Objects.hashCode(this.createDate);
        hash = 79 * hash + Objects.hashCode(this.commenter);
        hash = 79 * hash + this.published;
        hash = 79 * hash + this.pending;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comment other = (Comment) obj;
        if (this.commentId != other.commentId) {
            return false;
        }
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        if (this.postId != other.postId) {
            return false;
        }
        if (!Objects.equals(this.createDate, other.createDate)) {
            return false;
        }
        if (!Objects.equals(this.commenter, other.commenter)) {
            return false;
        }
        if (this.published != other.published) {
            return false;
        }
        if (this.pending != other.pending) {
            return false;
        }
        return true;
    }


    
}
