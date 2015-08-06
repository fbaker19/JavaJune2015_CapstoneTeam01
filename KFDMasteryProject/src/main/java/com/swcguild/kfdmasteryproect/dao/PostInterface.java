/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproect.dao;

import com.swcguild.kfdmasteryproject.model.Post;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface PostInterface {
    
    public Post addPost(Post post);
    public Post editPost(Post post);
    public void deletePost(int postId);
    public Post viewPost(int postId);
    public List<Post> viewAllPosts();
}
