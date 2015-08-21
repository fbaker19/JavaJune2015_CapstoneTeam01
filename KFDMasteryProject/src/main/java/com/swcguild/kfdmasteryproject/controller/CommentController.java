/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.controller;

import com.swcguild.kfdmasteryproject.dao.CommentInterface;
import com.swcguild.kfdmasteryproject.model.Comment;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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
public class CommentController {

    private CommentInterface com;

    @Inject
    public CommentController(CommentInterface com) {
        this.com = com;
    }

    @RequestMapping(value = {"/addComment"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addComment(@Valid @RequestBody Comment comment) {

        com.addComment(comment);
        
    }
    
    @RequestMapping(value="/comment/{commentId}", method=RequestMethod.GET)
    @ResponseBody public Comment viewComment(@PathVariable("commentId") int commentId){
        return com.viewComment(commentId);
    }
    
    @RequestMapping(value={"/publishComment"}, method=RequestMethod.POST)
@ResponseStatus(HttpStatus.OK)
public void publishComment(@RequestBody Comment comment){
   com.updateComment(comment);
}

@RequestMapping(value={"/deleteComment/{commentId}"}, method=RequestMethod.DELETE)
@ResponseStatus(HttpStatus.NO_CONTENT)
public void deleteComment(@PathVariable int commentId){
    com.deleteComment(commentId);
}

    
    
}


