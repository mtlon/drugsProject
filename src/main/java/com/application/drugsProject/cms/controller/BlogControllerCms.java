package com.application.drugsProject.cms.controller;

import com.application.drugsProject.cms.model.BlogModelCms;
import com.application.drugsProject.cms.model.DrugModelCms;
import com.application.drugsProject.cms.service.BlogServiceCms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cms")
public class BlogControllerCms {
    private BlogServiceCms blogServiceCms;

    @Autowired
    public BlogControllerCms(BlogServiceCms blogServiceCms) {
        this.blogServiceCms = blogServiceCms;
    }

    @GetMapping("/blog")
    public String listDrugs(Model model) {
        model.addAttribute("blog", blogServiceCms.getAllBlogModel());
        return "blog";
    }
    @GetMapping("/blog/new")
    public String createBlogModel(Model model) {
        BlogModelCms blog = new BlogModelCms();
        model.addAttribute("blog", blog);
        return "create_blog";
    }
    @PostMapping("/blog")
    public String saveBlogModel(@ModelAttribute("blog") BlogModelCms blog) {
        blogServiceCms.saveBlogModel(blog);
        return "redirect:/cms/blog";
    }
    @GetMapping("/blog/edit/{id}")
    public String editBlogModel(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogServiceCms.getBlogModelById(id));
        return "edit_blog";
    }

    @PostMapping("/blog/{id}")
    public String updateBlogModel(@PathVariable int id, @ModelAttribute("blog") BlogModelCms blogModelCms, Model model) {
        blogServiceCms.updateBlogModel(blogModelCms, id);
        return "redirect:/cms/blog";
    }
    @GetMapping("/blog/{id}")
    public String deleteDrug(@PathVariable int id) {
        blogServiceCms.deleteBlogModelById(id);
        return "redirect:/cms/blog";
    }
}
