package com.application.drugsProject.controller.APIcontroller;

import com.application.drugsProject.model.BlogModel;
import com.application.drugsProject.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogControllerAPI {
    private BlogService blogService;

    @Autowired
    public BlogControllerAPI(BlogService blogService) {
        this.blogService = blogService;
    }
    @GetMapping("")
    public ResponseEntity<List<BlogModel>> blogModelList() {
        List<BlogModel> blogModelList = blogService.getBlogModelList();
        return new ResponseEntity<>(blogModelList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogModel> getBlogModelByID(@PathVariable("id") int blogModelID) {
        BlogModel blogModel = blogService.getBlogModelById(blogModelID);
        return new ResponseEntity<>(blogModel, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<BlogModel> createBlogModel(@RequestBody BlogModel blogModel) {
        BlogModel newBlogModel = blogService.createBlogModel(blogModel);
        return new ResponseEntity<>(newBlogModel, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<BlogModel> updateBlogModel(@RequestBody BlogModel blogModel, @PathVariable("id") int blogModelID) {
        BlogModel updateBlogModel = blogService.updateBlogModel(blogModel, blogModelID);
        return new ResponseEntity<>(updateBlogModel, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBlogModel(@PathVariable("id") int blogModelID) {
        blogService.deleteBlogModel(blogModelID);
        return new ResponseEntity<>("Blog model deleted successfully", HttpStatus.OK);
    }
}
