package com.application.drugsProject.api.service;

import com.application.drugsProject.api.model.BlogModel;

import java.util.List;

public interface BlogService {
    List<BlogModel> getBlogModelList();
    BlogModel getBlogModelById(int id);
    BlogModel createBlogModel(BlogModel blogModel);
    BlogModel updateBlogModel(BlogModel blogModel, int blogModelID);
    void deleteBlogModel(int blogModelID);
}
