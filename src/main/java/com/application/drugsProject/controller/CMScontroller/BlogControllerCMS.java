package com.application.drugsProject.controller.CMScontroller;

import com.application.drugsProject.model.BlogModel;
import com.application.drugsProject.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cms")
public class BlogControllerCMS {
    private BlogService blogService;

    @Autowired
    public BlogControllerCMS(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blog")
    public String listDrugs(Model model) {
        model.addAttribute("blog", blogService.getBlogModelList());
        return "blog";
    }
    @GetMapping("/blog/new")
    public String createBlogModel(Model model) {
        BlogModel blog = new BlogModel();
        model.addAttribute("blog", blog);
        return "create_blog";
    }
    @PostMapping("/blog")
    public String saveBlogModel(@ModelAttribute("blog") BlogModel blog) {
        blogService.createBlogModel(blog);
        return "redirect:/cms/blog";
    }
    @GetMapping("/blog/edit/{id}")
    public String editBlogModel(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.getBlogModelById(id));
        return "edit_blog";
    }

    @PostMapping("/blog/{id}")
    public String updateBlogModel(@PathVariable int id, @ModelAttribute("blog") BlogModel blogModelCms, Model model) {
        blogService.updateBlogModel(blogModelCms, id);
        return "redirect:/cms/blog";
    }
    @GetMapping("/blog/{id}")
    public String deleteDrug(@PathVariable int id) {
        blogService.deleteBlogModel(id);
        return "redirect:/cms/blog";
    }
}

