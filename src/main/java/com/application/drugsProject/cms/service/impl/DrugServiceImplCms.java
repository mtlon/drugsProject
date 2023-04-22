package com.application.drugsProject.cms.service.impl;

import com.application.drugsProject.cms.model.DrugModelCms;
import com.application.drugsProject.cms.repository.DrugRepositoryCms;
import com.application.drugsProject.cms.service.DrugServiceCms;
import com.application.drugsProject.exception.DrugNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImplCms implements DrugServiceCms {

    private DrugRepositoryCms drugRepository;

    public DrugServiceImplCms(DrugRepositoryCms drugRepository) {
        super();
        this.drugRepository = drugRepository;
    }

    @Override
    public List<DrugModelCms> getAllDrugs() {
        return drugRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public DrugModelCms saveDrug(DrugModelCms drug) {
        DrugModelCms newDrug = new DrugModelCms();

        newDrug.setImage(drug.getImage());
        newDrug.setName(drug.getName());
        newDrug.setActiveSubstance(drug.getActiveSubstance());
        newDrug.setIndications(drug.getIndications());
        newDrug.setDosageTaking(drug.getDosageTaking());
        newDrug.setSpecialWarnings(drug.getSpecialWarnings());
        newDrug.setContraindications(drug.getContraindications());
        newDrug.setAdditionalInfo(drug.getAdditionalInfo());

        return drugRepository.save(newDrug);
    }

    @Override
    public DrugModelCms getDrugById(int id) {
        return drugRepository.findById(id).get();
    }

    @Override
    public DrugModelCms updateDrug(DrugModelCms drug, int id) {
        DrugModelCms updateDrug = drugRepository.findById(id)
                .orElseThrow(() -> new DrugNotFoundException("Drug was not found"));

        updateDrug.setImage(drug.getImage());
        updateDrug.setName(drug.getName());
        updateDrug.setActiveSubstance(drug.getActiveSubstance());
        updateDrug.setIndications(drug.getIndications());
        updateDrug.setDosageTaking(drug.getDosageTaking());
        updateDrug.setSpecialWarnings(drug.getSpecialWarnings());
        updateDrug.setContraindications(drug.getContraindications());
        updateDrug.setAdditionalInfo(drug.getAdditionalInfo());

        return drugRepository.save(updateDrug);
    }

    @Override
    public void deleteDrugById(int id) {
        getDrugById(id);
        drugRepository.deleteById(id);
    }

}
