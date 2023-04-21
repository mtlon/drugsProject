package com.application.drugsProject.cms.service.impl;

import com.application.drugsProject.cms.model.DrugCms;
import com.application.drugsProject.cms.repository.DrugRepositoryCms;
import com.application.drugsProject.cms.service.DrugServiceCms;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceCmsImpl implements DrugServiceCms {

    private DrugRepositoryCms drugRepository;

    public DrugServiceCmsImpl(DrugRepositoryCms drugRepository) {
        super();
        this.drugRepository = drugRepository;
    }

    @Override
    public List<DrugCms> getAllDrugs() {
        return drugRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public DrugCms saveDrug(DrugCms drug) {
        return drugRepository.save(drug);
    }

    @Override
    public DrugCms getDrugById(Long id) {
        return drugRepository.findById(id).get();
    }

    @Override
    public DrugCms updateDrug(DrugCms drug) {
        return drugRepository.save(drug);
    }

    @Override
    public void deleteDrugById(Long id) {
        drugRepository.deleteById(id);
    }

}
