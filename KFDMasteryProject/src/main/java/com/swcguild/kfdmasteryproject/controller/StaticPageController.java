/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.controller;

import com.swcguild.kfdmasteryproject.dao.PostInterface;
import com.swcguild.kfdmasteryproject.dao.StaticPageInterface;
import com.swcguild.kfdmasteryproject.model.Post;
import java.util.List;
import javax.inject.Inject;
import static javax.management.Query.value;
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
    
    @Inject
    public StaticPageController(StaticPageInterface sp, PostInterface pdao){
        this.pdao=pdao;
        this.sp=sp;
    }
    
    
   @RequestMapping(value={"/", "/index"}, method = RequestMethod.GET)
  public String displayHomePage()
   {
       return "index";
   }
  
    @RequestMapping(value={"/blogposts"}, method = RequestMethod.GET)
  public String displayBlogPage(Model model)
   {
       List<Post> pList = pdao.viewAllPosts();
       model.addAttribute("pList", pList);
       return "blogposts";
   }
  
  @RequestMapping(value={"/bossDashboard"}, method = RequestMethod.GET)
  public String displayBossDashboardPage()
   {
       return "bossDashboard";
   }
  
    
}
