/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.dao;

import com.swcguild.kfdmasteryproject.model.Image;
import com.swcguild.kfdmasteryproject.model.Post;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface PostInterface {

    public Post saveNewPost(Post post);

    public Post publishNewPost(Post post);

    public Post updatePost(Post post);

    public void deletePost(int postId);

    public Post viewPost(int postId);

    public List<Post> viewAllPublishedPosts();

    public List<Post> viewAllPublishedPostsByCategoryId(int categoryId);

    public Post viewLatestPost();

    public List<Post> viewAllPendingPosts();

    public Image addImage(Image image);

    public Image getImage(int image_id);
}
