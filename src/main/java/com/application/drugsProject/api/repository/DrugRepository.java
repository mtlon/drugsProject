package com.application.drugsProject.api.repository;

import com.application.drugsProject.api.model.DrugModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("converter")
public interface DrugRepository extends JpaRepository<DrugModel, Long> {
    Optional<DrugModel> findByName(String drugName);
}
