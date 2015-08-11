/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.controller;

import com.swcguild.kfdmasteryproject.dao.PostInterface;
import com.swcguild.kfdmasteryproject.dao.StaticPageInterface;
import com.swcguild.kfdmasteryproject.model.Post;
import com.swcguild.kfdmasteryproject.model.User;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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

@RequestMapping(value="/addPost", method=RequestMethod.GET)
public String displayAddPost(){
    return "addPost";
}
  
@RequestMapping(value="/savePost", method=RequestMethod.POST)
@ResponseStatus(HttpStatus.OK)
public void savePost(Post post, User user){
    
    pdao.savePost(post, user);
}
    
}
