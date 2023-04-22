package com.application.drugsProject.cms.repository;

import com.application.drugsProject.cms.model.BlogModelCms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepositoryCms extends JpaRepository<BlogModelCms, Integer> {
}
