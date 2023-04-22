package com.application.drugsProject.api.repository;

import com.application.drugsProject.api.model.HomeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<HomeModel, Integer> {
}
