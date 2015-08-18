/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.controller;

import com.swcguild.kfdmasteryproject.dao.PostInterface;
import com.swcguild.kfdmasteryproject.dao.StaticPageInterface;
import com.swcguild.kfdmasteryproject.model.Image;
import com.swcguild.kfdmasteryproject.model.Post;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author apprentice
 */
@Controller
public class PostController {

    private StaticPageInterface sp;
    private PostInterface pdao;

    @Inject
    public PostController(StaticPageInterface sp, PostInterface pdao) {
        this.pdao = pdao;
        this.sp = sp;

    }

    @RequestMapping(value = "/viewPost/{postId}", method = RequestMethod.GET)
    public String displayPost(@PathVariable("postId") int postId, Model model) {
        Post post = pdao.viewPost(postId);
        model.addAttribute("post", post);
        return "viewPost";
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.GET)
    public String displayAddPost(Model model) {
        Post post = new Post();
        post.setPostId(-1);
        model.addAttribute("post", post);
        return "addPost";
    }

    @RequestMapping(value = {"/savePost"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void savePost(@RequestBody Post post) {

        if (post.getPostId() < 0) {
            pdao.saveNewPost(post);
        } else {
            pdao.updatePost(post);
        }
    }


//EMPLOYEE EMPLOYEE //EMPLOYEE EMPLOYEE  //EMPLOYEE EMPLOYEE 

@RequestMapping(value="/addPostEmp", method=RequestMethod.GET)
public String displayEmpAddPost(Model model){
    Post post = new Post();
    post.setPostId(-1);
    model.addAttribute("post", post);
    return "addPostEmp";
}

@RequestMapping(value="/addPostEmp/{postId}", method=RequestMethod.GET)
public String displayEmpEditPost (@PathVariable("postId") int postId, Model model)
{
    Post post = pdao.viewPost(postId);
    model.addAttribute("post", post);
    return "addPostEmp";
}

    @RequestMapping(value = {"/saveEmpPost"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void saveEmpPost(@RequestBody Post post) {

        if (post.getPostId() < 0) {
            pdao.saveNewPost(post);
        } else {
            pdao.updatePost(post);
        }
    }



    @RequestMapping(value = "/addPost/{postId}", method = RequestMethod.GET)
    public String displayEditPost(@PathVariable("postId") int postId, Model model) {
        Post post = pdao.viewPost(postId);
        model.addAttribute("post", post);
        return "addPost";
    }

    @RequestMapping(value = {"/publishPost"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void publishPost(@RequestBody Post post) {
        if (post.getPostId() < 0) {
            pdao.publishNewPost(post);
        } else {
            pdao.updatePost(post);
        }
    }

    @RequestMapping(value = {"/deletePost/{postId}"}, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int postId) {
        pdao.deletePost(postId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postImage(@RequestParam("newImage") MultipartFile file, HttpServletRequest req, Model model) {
        Image image = new Image();
        Image newImage = null;
        try {
            image.setImage(file.getBytes());
            newImage = pdao.addImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("imagePath", req.getContextPath() + "/image/" + newImage.getImage_id());
        return "imageResponse";
    }

    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public void getImage(@PathVariable("id") int id, HttpServletResponse response) {
        Image image = pdao.getImage(id);
        try {
            response.setContentType("image/png");
            IOUtils.copy(new ByteArrayInputStream(image.getImage()), response.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
