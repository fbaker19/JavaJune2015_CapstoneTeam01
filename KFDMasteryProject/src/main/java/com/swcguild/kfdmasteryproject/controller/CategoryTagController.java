/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.kfdmasteryproject.controller;

import com.swcguild.kfdmasteryproject.dao.CategoryTagInterface;
import com.swcguild.kfdmasteryproject.model.Category;
import com.swcguild.kfdmasteryproject.model.Tag;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
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
public class CategoryTagController {

    private CategoryTagInterface cat;

    @Inject
    public CategoryTagController(CategoryTagInterface cat) {
        this.cat = cat;
    }

    @RequestMapping(value = {"/addCategory"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addCategory(@Valid @RequestBody Category category) {

        cat.addCategory(category);
    }

    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
    @ResponseBody
    public Category viewCategory(@PathVariable("categoryId") int categoryId) {
        return cat.viewCategory(categoryId);
    }

    @RequestMapping(value = {"/publishCategory"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void editCategory(@RequestBody Category category) {
        cat.editCategory(category);
    }

    @RequestMapping(value = {"/deleteCategory/{categoryId}"}, method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int categoryId) {
        cat.deleteCategory(categoryId);
    }
    
    @RequestMapping(value="/deleteCategory", method=RequestMethod.GET)
    public String deleteCategory(HttpServletRequest req) throws IOException {
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        cat.deleteCategory(categoryId);
        return "redirect:bossDashboard";
    }
    
    @RequestMapping(value = {"/addTag"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addTag(@RequestBody Tag tag) {

        cat.addTag(tag);
    }

    @RequestMapping(value = "/tag/{tagId}", method = RequestMethod.GET)
    @ResponseBody
    public Tag viewTag(@PathVariable("tagId") int tagId) {
        return cat.viewTag(tagId);
    }

}
