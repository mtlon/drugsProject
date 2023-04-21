package com.application.drugsProject.cms.controller;

import com.application.drugsProject.cms.model.DrugCms;
import com.application.drugsProject.cms.service.DrugServiceCms;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cms")
public class DrugControllerCms {
    private DrugServiceCms drugService;

    public DrugControllerCms(DrugServiceCms drugService) {
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

        DrugCms drug = new DrugCms();
        model.addAttribute("drug", drug);
        return "create_drug";

    }

    @PostMapping("/drugs")
    public String saveDrug(@ModelAttribute("drug") DrugCms drug) {
        drugService.saveDrug(drug);
        return "redirect:/cms/drugs";
    }

    @GetMapping("/drugs/edit/{id}")
    public String editDrugForm(@PathVariable Long id, Model model) {
        model.addAttribute("drug", drugService.getDrugById(id));
        return "edit_drugs";
    }

    @PostMapping("/drugs/{id}")
    public String updateDrug(@PathVariable Long id,
                                @ModelAttribute("drug") DrugCms drug,
                                Model model) {

        DrugCms existingDrug = drugService.getDrugById(id);
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
        return "redirect:/cms/drugs";
    }

    @GetMapping("/drugs/{id}")
    public String deleteDrug(@PathVariable Long id) {
        drugService.deleteDrugById(id);
        return "redirect:/cms/drugs";
    }
}
