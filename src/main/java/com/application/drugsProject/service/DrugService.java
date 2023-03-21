package com.application.drugsProject.service;

import com.application.drugsProject.model.Drug;

import java.util.List;

public interface DrugService {
    List<Drug> getAllDrugs();
    Drug newDrag(Drug drug);
    Drug updateDrug(Drug drug, int id);
    void deleteDrug(int id);
}
