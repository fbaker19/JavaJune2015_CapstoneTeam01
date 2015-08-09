/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproect.dao;

import com.swcguild.kfdmasteryproject.model.StaticPage;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface StaticPageInterface {
    
   public StaticPage addContent(StaticPage staticPage);
   
   public void editContent (StaticPage staticPage);
   
   public StaticPage viewContentById (int pageId);
   
   public List<StaticPage> viewAllContent ();
    
   public void deleteContent(int pageId);
      
}
