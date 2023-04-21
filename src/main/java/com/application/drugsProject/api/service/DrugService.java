package com.application.drugsProject.api.service;

import com.application.drugsProject.api.model.DrugModel;

import java.util.List;

public interface DrugService {
    List<DrugModel> getDrugsList();
    DrugModel getDrugById(Long id);
    DrugModel createDrug(DrugModel drugModel);
    DrugModel updateDrug(DrugModel drugModel, long drugID);
    void deleteDrug(long drugID);
}
