package com.application.drugsProject.service.impl;

import com.application.drugsProject.model.Drug;
import com.application.drugsProject.repository.DrugRepository;
import com.application.drugsProject.service.DrugService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    private DrugRepository drugRepository;

    public DrugServiceImpl(DrugRepository drugRepository) {
        super();
        this.drugRepository = drugRepository;
    }

    @Override
    public List<Drug> getAllDrugs() {
        return drugRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Drug saveDrug(Drug drug) {
        return drugRepository.save(drug);
    }

    @Override
    public Drug getDrugById(Long id) {
        return drugRepository.findById(id).get();
    }

    @Override
    public Drug updateDrug(Drug drug) {
        return drugRepository.save(drug);
    }

    @Override
    public void deleteDrugById(Long id) {
        drugRepository.deleteById(id);
    }

}
