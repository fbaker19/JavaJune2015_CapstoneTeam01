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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class CategoryTagImpl implements CategoryTagInterface {
    
       private static final String SQL_INSERT_CATEGORY = "";
       private static final String SQL_DELETE_CATEGORY = "";
       private static final String SQL_UPDATE_CATEGORY = "";
       private static final String SQL_SELECT_CATEGORY = "";
       private static final String SQL_SELECT_ALL_CATEGORIES = "";
       
       private static final String SQL_INSERT_TAG = "";
       private static final String SQL_SELECT_TAG = "";
       private static final String SQL_SELECT_ALL_POSTS_WITH_TAG = "";
    

       
      private JdbcTemplate jdbcTemplate;
      
      private void setJdbcTemplate(JdbcTemplate jdbcTemplate)
      {
          this.jdbcTemplate = jdbcTemplate;
      }

      
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly=false)
    public Category addCategory(Category category) {
        jdbcTemplate.update(SQL_INSERT_CATEGORY,
                category.getCategoryName()
                );
            category.setCategoryId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
            return category;
    }

    @Override
    public void editCategory(Category category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCategory(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Category viewCategory(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> viewPostsByCategory(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    

    @Override
    public Tag addTag(Tag tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tag viewTag(int tagId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//all
    public List<Post> viewPostsByTag(int tagId) {
      throw new UnsupportedOperationException("Not supported yet.");  
    }
    
}
