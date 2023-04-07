package com.application.drugsProject.controller;

import com.application.drugsProject.model.Drug;
import com.application.drugsProject.service.DrugService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DrugController {

    private DrugService drugService;

    public DrugController(DrugService drugService) {
        super();
        this.drugService = drugService;
    }

    @GetMapping("/drugs")
    public String listDrugs(Model model) {
        model.addAttribute("drugs", drugService.getAllDrugs());
        return "drugs";
    }

    @GetMapping("/drugs/new")
    public String createDrugForm(Model model) {

        Drug drug = new Drug();
        model.addAttribute("drug", drug);
        return "create_drug";

    }

    @PostMapping("/drugs")
    public String saveDrug(@ModelAttribute("drug") Drug drug) {
        drugService.saveDrug(drug);
        return "redirect:/drugs";
    }

    @GetMapping("/drugs/edit/{id}")
    public String editDrugForm(@PathVariable Long id, Model model) {
        model.addAttribute("drug", drugService.getDrugById(id));
        return "edit_drugs";
    }

    @PostMapping("/drugs/{id}")
    public String updateDrug(@PathVariable Long id,
                                @ModelAttribute("drug") Drug drug,
                                Model model) {

        Drug existingDrug = drugService.getDrugById(id);
        existingDrug.setId(id);
        existingDrug.setId(drug.getId());
        existingDrug.setActiveSubstance(drug.getActiveSubstance());
        existingDrug.setName(drug.getName());
        existingDrug.setDosageTaking(drug.getDosageTaking());
        existingDrug.setImage(drug.getImage());
        existingDrug.setSpecialWarnings(drug.getSpecialWarnings());
        existingDrug.setContraindications(drug.getContraindications());
        existingDrug.setAdditionalInfo(drug.getAdditionalInfo());
        existingDrug.setIndications(drug.getIndications());
        existingDrug.setForm(drug.getForm());
        existingDrug.setPrice(drug.getPrice());
        existingDrug.setProducer(drug.getProducer());

        drugService.updateDrug(existingDrug);
        return "redirect:/drugs";
    }

    @GetMapping("/drugs/{id}")
    public String deleteDrug(@PathVariable Long id) {
        drugService.deleteDrugById(id);
        return "redirect:/drugs";
    }
}
