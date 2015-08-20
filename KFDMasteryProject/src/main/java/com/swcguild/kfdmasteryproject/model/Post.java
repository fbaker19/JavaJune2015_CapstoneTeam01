 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Post {

    private int postId;
    private String content;
    private String blurb;
    private String title;
    private int userId;
    private int lastModifiedUserId;
    private Date createDate;
    private Date lastModifiedDate;
    private Date expDate;
    private int published;
    private int pending;
    private int categoryId;

    public int getPending() {
        return pending;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLastModifiedUserId() {
        return lastModifiedUserId;
    }

    public void setLastModifiedUserId(int lastModifiedUserId) {
        this.lastModifiedUserId = lastModifiedUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }


    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }
    
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.postId;
        hash = 37 * hash + Objects.hashCode(this.content);
        hash = 37 * hash + Objects.hashCode(this.blurb);
        hash = 37 * hash + Objects.hashCode(this.title);
        hash = 37 * hash + this.userId;
        hash = 37 * hash + this.lastModifiedUserId;
        hash = 37 * hash + Objects.hashCode(this.createDate);
        hash = 37 * hash + Objects.hashCode(this.lastModifiedDate);
        hash = 37 * hash + Objects.hashCode(this.expDate);
        hash = 37 * hash + this.published;
        hash = 37 * hash + this.pending;
        hash = 37 * hash + this.categoryId;
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
        final Post other = (Post) obj;
        if (this.postId != other.postId) {
            return false;
        }
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        if (!Objects.equals(this.blurb, other.blurb)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        if (this.lastModifiedUserId != other.lastModifiedUserId) {
            return false;
        }
        if (!Objects.equals(this.createDate, other.createDate)) {
            return false;
        }
        if (!Objects.equals(this.lastModifiedDate, other.lastModifiedDate)) {
            return false;
        }
        if (!Objects.equals(this.expDate, other.expDate)) {
            return false;
        }
        if (this.published != other.published) {
            return false;
        }
        if (this.pending != other.pending) {
            return false;
        }
        if (this.categoryId != other.categoryId) {
            return false;
        }
        return true;
    }

    
    
}
