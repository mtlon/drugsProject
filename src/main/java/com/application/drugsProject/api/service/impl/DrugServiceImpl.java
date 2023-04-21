package com.application.drugsProject.api.service.impl;

import com.application.drugsProject.api.exception.DrugNotFoundException;
import com.application.drugsProject.api.model.DrugModel;
import com.application.drugsProject.api.repository.DrugRepository;
import com.application.drugsProject.api.service.DrugService;
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
    public List<DrugModel> getDrugsList() {
        List<DrugModel> drugs = drugRepository.findAll();
        return drugs.stream().toList();
    }

    @Override
    public DrugModel getDrugById(Long id) {
        DrugModel drug = drugRepository.findById(id)
                .orElseThrow(() -> new DrugNotFoundException("Drug not found in database"));
        return drug;
    }

    @Override
    public DrugModel createDrug(DrugModel drugModel) {
        DrugModel drug = drugRepository.findByName(drugModel.getName())
                .orElseThrow(()-> new RuntimeException("Drug exist in database"));

        drug.setActiveSubstance(drug.getActiveSubstance());
        drug.setName(drug.getName());
        drug.setDosageTaking(drug.getDosageTaking());
        drug.setImage(drug.getImage());
        drug.setSpecialWarnings(drug.getSpecialWarnings());
        drug.setContraindications(drug.getContraindications());
        drug.setAdditionalInfo(drug.getAdditionalInfo());
        drug.setIndications(drug.getIndications());
        drug.setForm(drug.getForm());
        drug.setPrice(drug.getPrice());
        drug.setProducer(drug.getProducer());

        drugRepository.save(drug);
        return drug;
        }

    @Override
    public DrugModel updateDrug(DrugModel drugModel, long drugID) {
        DrugModel existingDrug = drugRepository.findById(drugID)
                .orElseThrow(()-> new DrugNotFoundException("Drug not found"));

        existingDrug.setActiveSubstance(drugModel.getActiveSubstance());
        existingDrug.setName(drugModel.getName());
        existingDrug.setDosageTaking(drugModel.getDosageTaking());
        existingDrug.setImage(drugModel.getImage());
        existingDrug.setSpecialWarnings(drugModel.getSpecialWarnings());
        existingDrug.setContraindications(drugModel.getContraindications());
        existingDrug.setAdditionalInfo(drugModel.getAdditionalInfo());
        existingDrug.setIndications(drugModel.getIndications());
        existingDrug.setForm(drugModel.getForm());
        existingDrug.setPrice(drugModel.getPrice());
        existingDrug.setProducer(drugModel.getProducer());

        drugRepository.save(existingDrug);
        return existingDrug;
    }

    @Override
    public void deleteDrug(long drugID) {
        DrugModel drugModel = drugRepository.findById(drugID)
                .orElseThrow(()-> new DrugNotFoundException("Drug was not found"));

        drugRepository.delete(drugModel);
    }
}

