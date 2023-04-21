package com.application.drugsProject.cms.service;

import com.application.drugsProject.cms.model.DrugCms;

import java.util.List;

public interface DrugServiceCms {
    List<DrugCms> getAllDrugs();
    DrugCms saveDrug(DrugCms drug);
    DrugCms getDrugById(Long id);
    DrugCms updateDrug(DrugCms drug);
    void deleteDrugById(Long id);
}
