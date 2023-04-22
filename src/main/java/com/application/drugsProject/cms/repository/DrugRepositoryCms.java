package com.application.drugsProject.cms.repository;

import com.application.drugsProject.cms.model.DrugModelCms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DrugRepositoryCms extends JpaRepository<DrugModelCms, Integer> {

}
