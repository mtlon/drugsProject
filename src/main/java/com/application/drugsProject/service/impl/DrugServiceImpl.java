package com.application.drugsProject.service.impl;

import com.application.drugsProject.exception.DrugNotFoundController;
import com.application.drugsProject.model.Drug;
import com.application.drugsProject.repository.DrugRepository;
import com.application.drugsProject.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {
    private DrugRepository drugRepository;

    @Autowired
    public DrugServiceImpl(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }
    @Override
    public List<Drug> getAllDrugs() {
        List<Drug> drugs = drugRepository.findAll();
        return drugs;
    }
    @Override
    public Drug newDrag(Drug drug) {
        Drug newDrug = new Drug();

        newDrug.setName(drug.getName());
        newDrug.setPrice(drug.getPrice());
        newDrug.setForm(drug.getForm());
        newDrug.setProducer(drug.getProducer());

        drugRepository.save(newDrug);
        return newDrug;
    }
    @Override
    public Drug updateDrug(Drug drug, int id) {
        Drug updateDrug = drugRepository.findById(id).orElseThrow(()-> new DrugNotFoundController("Drug not found"));

        updateDrug.setName(drug.getName());
        updateDrug.setPrice(drug.getPrice());
        updateDrug.setForm(drug.getForm());
        updateDrug.setProducer(drug.getProducer());

        Drug updatedDrug = drugRepository.save(updateDrug);
        return updatedDrug;
    }

    @Override
    public void deleteDrug(int id) {
        Drug updateDrug = drugRepository.findById(id).orElseThrow(()-> new DrugNotFoundController("Drug not found"));
        drugRepository.delete(updateDrug);
        System.out.println("Deleted successfully");
    }
}
