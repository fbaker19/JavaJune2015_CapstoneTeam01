/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproect.dao;

import com.swcguild.kfdmasteryproject.model.Category;
import com.swcguild.kfdmasteryproject.model.Post;
import com.swcguild.kfdmasteryproject.model.Tag;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface CategoryTagInterface {
    
    public Category addCategory(Category category);
    
    public Category editCategory(Category category);
    
    public void deleteCategory(int categoryId);
    
    public Category viewCategory(int categoryId);
    
    public List<Post> viewPostsByCategory(int categoryId);
    
   public Tag addTag(Tag tag);
   
   public Tag viewTag(int tagId);
   
   public List<Post> viewPostsByTag(int tagId);
    
}
