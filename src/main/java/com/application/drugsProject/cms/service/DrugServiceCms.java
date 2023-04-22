package com.application.drugsProject.cms.service;

import com.application.drugsProject.cms.model.DrugModelCms;

import java.util.List;

public interface DrugServiceCms {
    List<DrugModelCms> getAllDrugs();
    DrugModelCms saveDrug(DrugModelCms drug);
    DrugModelCms getDrugById(int id);
    DrugModelCms updateDrug(DrugModelCms drug, int id);
    void deleteDrugById(int id);
}
