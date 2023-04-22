package com.application.drugsProject.cms.repository;

import com.application.drugsProject.cms.model.HomeModelCms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepositoryCms extends JpaRepository<HomeModelCms, Integer> {
}
