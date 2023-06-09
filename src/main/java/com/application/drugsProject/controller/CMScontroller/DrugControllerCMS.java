package com.application.drugsProject.controller.CMScontroller;

import com.application.drugsProject.model.DrugModel;
import com.application.drugsProject.service.DrugService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/cms")
public class DrugControllerCMS {
    private DrugService drugService;

    public DrugControllerCMS(DrugService drugService) {
        super();
        this.drugService = drugService;
    }

    @GetMapping("/drugs")
    public String listDrugs(Model model) {
        model.addAttribute("drugs", drugService.getDrugsList());
        return "drug/drugs";
    }

    @GetMapping("/drugs/new")
    public String createDrugForm(Model model) {
        DrugModel drug = new DrugModel();
        model.addAttribute("drug", drug);
        return "drug/create_drug";

    }
    @PostMapping("/drugs")
    public String saveDrug(@ModelAttribute("drug") DrugModel drug) throws IOException {
        drugService.createDrug(drug);
        return "redirect:/cms/drugs";
    }

    @GetMapping("/drugs/edit/{id}")
    public String editDrugForm(@PathVariable int id, Model model) {
        model.addAttribute("drug", drugService.getDrugById(id));
        return "drug/edit_drugs";
    }

    @PostMapping("/drugs/{id}")
    public String updateDrug(@PathVariable int id,
                             @ModelAttribute("drug") DrugModel drug,
                             Model model) throws IOException {
        drugService.updateDrug(drug, id);
        return "redirect:/cms/drugs";
    }

    @GetMapping("/drugs/{id}")
    public String deleteDrug(@PathVariable int id) {
        drugService.deleteDrug(id);
        return "redirect:/cms/drugs";
    }
}


