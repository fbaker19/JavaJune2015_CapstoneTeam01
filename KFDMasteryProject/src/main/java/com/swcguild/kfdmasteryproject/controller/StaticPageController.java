/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.controller;

import static javax.management.Query.value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class StaticPageController {
    
   @RequestMapping(value={"/", "/index"}, method = RequestMethod.GET)
  public String displayHomePage()
   {
       return "index";
   }
  
    @RequestMapping(value={"/blogposts"}, method = RequestMethod.GET)
  public String displayBlogPage()
   {
       return "blogposts";
   }
  
    
}
