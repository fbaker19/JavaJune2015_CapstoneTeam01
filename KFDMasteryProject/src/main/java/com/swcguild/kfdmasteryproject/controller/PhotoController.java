/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.controller;

import com.swcguild.kfdmasteryproject.dao.PostInterface;
import com.swcguild.kfdmasteryproject.model.Photo;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
public class PhotoController {
    
    private PostInterface dao; 
    
    @Inject
    public PhotoController(PostInterface dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/photo", method = RequestMethod.POST)
    @ResponseBody
    public Photo addPhoto(@RequestBody Photo photo) {
        
        
        
        return photo;
    }

}
