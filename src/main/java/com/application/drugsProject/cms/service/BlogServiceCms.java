package com.application.drugsProject.cms.service;

import com.application.drugsProject.cms.model.BlogModelCms;

import java.util.List;

public interface BlogServiceCms {
    List<BlogModelCms> getAllBlogModel();
    BlogModelCms saveBlogModel(BlogModelCms blogModelCms);
    BlogModelCms getBlogModelById(int id);
    BlogModelCms updateBlogModel(BlogModelCms blogModelCms, int id);
    void deleteBlogModelById(int id);
}
