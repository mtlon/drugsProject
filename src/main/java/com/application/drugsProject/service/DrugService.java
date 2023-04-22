package com.application.drugsProject.service;

import com.application.drugsProject.model.DrugModel;

import java.util.List;

public interface DrugService {
    List<DrugModel> getDrugsList();
    DrugModel getDrugById(int id);
    DrugModel createDrug(DrugModel drugModel);
    DrugModel updateDrug(DrugModel drugModel, int drugID);
    void deleteDrug(int drugID);
}
