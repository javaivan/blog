package com.mixdev.blog.web;

import com.mixdev.blog.domain.Category;
import com.mixdev.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by mix on 06.02.2016.
 */
@Controller
public class CategoryControler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryControler.class);

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = {"/category-add"},method = RequestMethod.GET)
    public String newCategory(ModelMap model){
        LOGGER.debug("Rendering New Category page.");
        model.addAttribute("category",new Category());
        return "category-add";
    }

    @RequestMapping(value = {"/category-add"},method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("category") Category postCategory,
                                  BindingResult result){
        LOGGER.debug("Added a Category entry with information: {}", postCategory);
        categoryService.save(postCategory);
        return "redirect:/category-all";
    }

    @RequestMapping(value = {"/category-all"},method = RequestMethod.GET)
    public String allCategory(ModelMap model) {
        LOGGER.debug("Rendering All Category page.");
        List<Category> categorys = categoryService.findAll();
        model.addAttribute("categoryList" , categorys);
        return "category-all";
    }
}
