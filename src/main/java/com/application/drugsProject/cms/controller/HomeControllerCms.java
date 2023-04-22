package com.application.drugsProject.cms.controller;

import com.application.drugsProject.cms.model.DrugModelCms;
import com.application.drugsProject.cms.model.HomeModelCms;
import com.application.drugsProject.cms.service.HomeServiceCms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cms/home")
public class HomeControllerCms {
    private HomeServiceCms homeService;

    @Autowired
    public HomeControllerCms(HomeServiceCms homeService) {
        this.homeService = homeService;
    }
    @GetMapping("")
    public String listHomeModels(Model model) {
        model.addAttribute("home", homeService.getAllHomeModels());
        return "home";
    }
    @GetMapping("/new")
    public String createHomeModel(Model model) {
        HomeModelCms home = new HomeModelCms();
        model.addAttribute("home", home);
        return "create_home";

    }
    @PostMapping("")
    public String saveHomeModel(@ModelAttribute("home") HomeModelCms homeModel) {
        homeService.saveHomeModel(homeModel);
        return "redirect:/cms/home";
    }

    @GetMapping("/edit/{id}")
    public String editHomeModel(@PathVariable int id, Model model) {
        model.addAttribute("home", homeService.getHomeModelById(id));
        return "edit_home";
    }

    @PostMapping("/{id}")
    public String updateHomeModel(@PathVariable int id,
                             @ModelAttribute("home") HomeModelCms homeModel,
                             Model model) {
        homeService.updateHomeModel(homeModel, id);
        return "redirect:/cms/home";
    }

    @GetMapping("/{id}")
    public String deleteHomeModel(@PathVariable int id) {
        homeService.deleteHomeModelById(id);
        return "redirect:/cms/home";
    }
}
