package com.application.drugsProject.api.repository;

import com.application.drugsProject.api.model.BlogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<BlogModel, Integer> {
}
