package com.application.drugsProject.repository;

import com.application.drugsProject.model.DrugModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends JpaRepository<DrugModel, Integer> {

}
