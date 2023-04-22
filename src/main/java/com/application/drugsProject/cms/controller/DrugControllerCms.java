package com.application.drugsProject.cms.controller;

import com.application.drugsProject.cms.model.DrugModelCms;
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
        DrugModelCms drug = new DrugModelCms();
        model.addAttribute("drug", drug);
        return "create_drug";

    }
    @PostMapping("/drugs")
    public String saveDrug(@ModelAttribute("drug") DrugModelCms drug) {
        drugService.saveDrug(drug);
        return "redirect:/cms/drugs";
    }

    @GetMapping("/drugs/edit/{id}")
    public String editDrugForm(@PathVariable int id, Model model) {
        model.addAttribute("drug", drugService.getDrugById(id));
        return "edit_drugs";
    }

    @PostMapping("/drugs/{id}")
    public String updateDrug(@PathVariable int id,
                                @ModelAttribute("drug") DrugModelCms drug,
                                Model model) {
        drugService.updateDrug(drug, id);
        return "redirect:/cms/drugs";
    }

    @GetMapping("/drugs/{id}")
    public String deleteDrug(@PathVariable int id) {
        drugService.deleteDrugById(id);
        return "redirect:/cms/drugs";
    }
}
