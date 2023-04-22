package com.application.drugsProject.service;

import com.application.drugsProject.model.BlogModel;

import java.util.List;

public interface BlogService {
    List<BlogModel> getBlogModelList();
    BlogModel getBlogModelById(int id);
    BlogModel createBlogModel(BlogModel blogModel);
    BlogModel updateBlogModel(BlogModel blogModel, int blogModelID);
    void deleteBlogModel(int blogModelID);
}
