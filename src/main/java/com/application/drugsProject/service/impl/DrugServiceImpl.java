package com.application.drugsProject.service.impl;

import com.application.drugsProject.exception.DrugNotFoundException;
import com.application.drugsProject.model.DrugModel;
import com.application.drugsProject.repository.DrugRepository;
import com.application.drugsProject.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
        List<DrugModel> drugs = drugRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return drugs.stream().toList();
    }

    @Override
    public DrugModel getDrugById(int id) {
        DrugModel drug = drugRepository.findById(id)
                .orElseThrow(() -> new DrugNotFoundException("Drug not found in database"));
        return drug;
    }

    @Override
    public DrugModel createDrug(DrugModel drugModel) {
        DrugModel drug = new DrugModel();
        return getDrugModel(drugModel, drug);
    }

    @Override
    public DrugModel updateDrug(DrugModel drugModel, int drugID) {
        DrugModel drug = drugRepository.findById(drugID)
                .orElseThrow(()-> new DrugNotFoundException("Drug not found"));

        return getDrugModel(drugModel, drug);
    }

    private DrugModel getDrugModel(DrugModel drugModel, DrugModel drug) {
        drug.setActiveSubstance(drugModel.getActiveSubstance());
        drug.setName(drugModel.getName());
        drug.setDosageTaking(drugModel.getDosageTaking());
        drug.setImage(drugModel.getImage());
        drug.setSpecialWarnings(drugModel.getSpecialWarnings());
        drug.setContraindications(drugModel.getContraindications());
        drug.setAdditionalInfo(drugModel.getAdditionalInfo());
        drug.setIndications(drugModel.getIndications());
        drug.setForm(drugModel.getForm());
        drug.setPrice(drugModel.getPrice());
        drug.setProducer(drugModel.getProducer());

        drugRepository.save(drug);
        return drug;
    }

    @Override
    public void deleteDrug(int drugID) {
        getDrugById(drugID);
        drugRepository.deleteById(drugID);
    }
}

