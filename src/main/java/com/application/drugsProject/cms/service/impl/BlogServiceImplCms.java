package com.application.drugsProject.cms.service.impl;

import com.application.drugsProject.cms.model.BlogModelCms;
import com.application.drugsProject.cms.repository.BlogRepositoryCms;
import com.application.drugsProject.cms.service.BlogServiceCms;
import com.application.drugsProject.exception.BlogModelNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImplCms implements BlogServiceCms {
    private BlogRepositoryCms blogRepositoryCms;

    @Autowired
    public BlogServiceImplCms(BlogRepositoryCms blogRepositoryCms) {
        this.blogRepositoryCms = blogRepositoryCms;
    }

    @Override
    public List<BlogModelCms> getAllBlogModel() {
        return blogRepositoryCms.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
    @Override
    public BlogModelCms getBlogModelById(int id) {
        return blogRepositoryCms.findById(id).get();
    }

    @Override
    public BlogModelCms saveBlogModel(BlogModelCms blogModelCms) {
        BlogModelCms newBlogModel = new BlogModelCms();
        newBlogModel.setImage(blogModelCms.getImage());
        newBlogModel.setTitle(blogModelCms.getTitle());
        newBlogModel.setDescription(blogModelCms.getDescription());
        newBlogModel.setContent(blogModelCms.getContent());

        return blogRepositoryCms.save(newBlogModel);
    }

    @Override
    public BlogModelCms updateBlogModel(BlogModelCms blogModelCms, int id) {
        BlogModelCms updateBlogModel = blogRepositoryCms.findById(id)
                .orElseThrow(() -> new BlogModelNotFoundException("Blog model not found"));

        updateBlogModel.setImage(blogModelCms.getImage());
        updateBlogModel.setTitle(blogModelCms.getTitle());
        updateBlogModel.setDescription(blogModelCms.getDescription());
        updateBlogModel.setContent(blogModelCms.getContent());
        blogRepositoryCms.save(updateBlogModel);
        return blogModelCms;
    }

    @Override
    public void deleteBlogModelById(int id) {
        blogRepositoryCms.deleteById(id);
    }
}
