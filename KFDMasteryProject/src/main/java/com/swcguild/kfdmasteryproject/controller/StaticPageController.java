/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.controller;

import com.swcguild.kfdmasteryproject.dao.CategoryTagInterface;
import com.swcguild.kfdmasteryproject.dao.CommentInterface;
import com.swcguild.kfdmasteryproject.model.Category;
import com.swcguild.kfdmasteryproject.model.Comment;
import com.swcguild.kfdmasteryproject.dao.PostInterface;
import com.swcguild.kfdmasteryproject.dao.StaticPageInterface;
import com.swcguild.kfdmasteryproject.dao.PostInterface;
import com.swcguild.kfdmasteryproject.dao.StaticPageInterface;
import com.swcguild.kfdmasteryproject.model.Post;
import com.swcguild.kfdmasteryproject.model.StaticPage;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class StaticPageController {
    
    private StaticPageInterface sp;
    private PostInterface pdao;
    private CommentInterface com;
    private CategoryTagInterface cat;
    
    @Inject
    public StaticPageController(StaticPageInterface sp, PostInterface pdao, CommentInterface com, CategoryTagInterface cat){
        this.pdao=pdao;
        this.sp=sp;
        this.com=com;
        this.cat=cat;
    }
    
    
   @RequestMapping(value={"/", "/index"}, method = RequestMethod.GET)
  public String displayHomePage(Model model)
   {
       Post currentPost=pdao.viewLatestPost();
       model.addAttribute("currentPost", currentPost);
       return "index";
   }
  
    @RequestMapping(value={"/blogposts"}, method = RequestMethod.GET)
  public String displayBlogPage(Model model)
   {
       List<Post> pList = pdao.viewAllPublishedPosts();
       model.addAttribute("pList", pList);
       return "blogposts";
   }
  
  @RequestMapping(value={"/bossDashboard"}, method = RequestMethod.GET)
  public String displayDashboard(Model model)
   {
       List<Post> ppList = pdao.viewAllPendingPosts();
       List<Comment> pcList = com.viewAllPendingComments();
       List<StaticPage> spList = sp.viewAllContent();
       List<Category> catList = cat.viewAllCategories();
       
       model.addAttribute("ppList", ppList);
       model.addAttribute("pcList", pcList);
       model.addAttribute("spList", spList);
       model.addAttribute("catList", catList);
       
       return "bossDashboard";
   }
  
 @RequestMapping(value="/addPage", method=RequestMethod.GET)
 public String displayAddPage(){
     return "addPage";
 }
    
}
