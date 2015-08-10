/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.controller;

import com.swcguild.kfdmasteryproect.dao.PostInterface;
import com.swcguild.kfdmasteryproect.dao.StaticPageInterface;
import com.swcguild.kfdmasteryproject.model.Post;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
public class PostController {
    
    private StaticPageInterface sp;
    private PostInterface pdao;
    
    @Inject
    public PostController(StaticPageInterface sp, PostInterface pdao){
        this.pdao=pdao;
        this.sp=sp;
    }
    
    
@RequestMapping(value="/viewPost/{postId}", method = RequestMethod.GET)
public String displayPost(@PathVariable("postId") int postId, Model model)
   {
       Post post = pdao.viewPost(postId);
       model.addAttribute("post", post);
       return "viewPost";
   }
  
    
}
