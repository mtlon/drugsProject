package com.application.drugsProject.service.impl;

import com.application.drugsProject.exception.BlogModelNotFoundException;
import com.application.drugsProject.model.BlogModel;
import com.application.drugsProject.repository.BlogRepository;
import com.application.drugsProject.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    private BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<BlogModel> getBlogModelList() {
        List<BlogModel> blogModels = blogRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return blogModels.stream().toList();
    }

    @Override
    public BlogModel getBlogModelById(int id) {
        BlogModel blogModel = blogRepository.findById(id)
                .orElseThrow(() -> new BlogModelNotFoundException("Blog model was not found in database"));
        return blogModel;
    }

    @Override
    public BlogModel createBlogModel(BlogModel blogModel) {
        BlogModel newBlogModel = new BlogModel();

        newBlogModel.setImage(blogModel.getImage());
        newBlogModel.setTitle(blogModel.getTitle());
        newBlogModel.setContent(blogModel.getContent());
        newBlogModel.setDescription(blogModel.getDescription());

        blogRepository.save(newBlogModel);
        return newBlogModel;
    }

    @Override
    public BlogModel updateBlogModel(BlogModel blogModel, int blogModelID) {
        BlogModel updatedModel = blogRepository.findById(blogModelID)
                .orElseThrow(() -> new BlogModelNotFoundException("Blog model was not found in database"));

        updatedModel.setImage(blogModel.getImage());
        updatedModel.setTitle(blogModel.getTitle());
        updatedModel.setDescription(blogModel.getDescription());
        updatedModel.setContent(blogModel.getContent());

        blogRepository.save(updatedModel);
        return updatedModel;
    }

    @Override
    public void deleteBlogModel(int blogModelID) {
        getBlogModelById(blogModelID);
        blogRepository.deleteById(blogModelID);
    }
}
