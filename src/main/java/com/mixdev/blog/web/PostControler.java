package com.mixdev.blog.web;

import com.mixdev.blog.domain.Category;
import com.mixdev.blog.domain.Post;
import com.mixdev.blog.service.CategoryService;
import com.mixdev.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by osven on 04.02.16.
 */

@Controller
@SessionAttributes("cat")
public class PostControler {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostControler.class);

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = {"/post-add"}, method = RequestMethod.GET)
    public String addPostPage(ModelMap model) {
        LOGGER.debug("Rendering Add Post page.");
        Post post = new Post();
        model.addAttribute("post", post);
        return "post-add";
    }

    @RequestMapping(value = {"/post-add"}, method = RequestMethod.POST)
    public String addPost(@ModelAttribute("post") Post post,
                             BindingResult result) {
        LOGGER.debug("Added a Post entry with information: {}", post);
        postService.save(post);
        return "redirect:/post-all";
    }

    @RequestMapping(value = {"/post-all"}, method = RequestMethod.GET)
    public String listPosts(ModelMap model) {
        LOGGER.debug("Rendering All Post page.");

        List<Post> posts = postService.findAll();
        model.addAttribute("postList" , posts);
        return "post-all";
    }

    @ModelAttribute("cat")
    public List<Category> initializeProfiles() {return categoryService.findAll();}
}
