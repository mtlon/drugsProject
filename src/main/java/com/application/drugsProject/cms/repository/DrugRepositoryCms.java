package com.application.drugsProject.cms.repository;

import com.application.drugsProject.cms.model.DrugCms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DrugRepositoryCms extends JpaRepository<DrugCms, Long> {

}
