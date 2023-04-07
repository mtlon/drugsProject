package com.application.drugsProject.service;

import com.application.drugsProject.model.Drug;

import java.util.List;

public interface DrugService {
    List<Drug> getAllDrugs();
    Drug saveDrug(Drug drug);
    Drug getDrugById(Long id);
    Drug updateDrug(Drug drug);
    void deleteDrugById(Long id);
}
