package com.application.drugsProject.controller.CMScontroller;

import com.application.drugsProject.model.HomeModel;
import com.application.drugsProject.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cms/home")
public class HomeControllerCMS {
    private HomeService homeService;

    @Autowired
    public HomeControllerCMS(HomeService homeService) {
        this.homeService = homeService;
    }
    @GetMapping("")
    public String listHomeModels(Model model) {
        model.addAttribute("home", homeService.getAllHomeModels());
        return "home/home";
    }
    @GetMapping("/new")
    public String createHomeModel(Model model) {
        HomeModel home = new HomeModel();
        model.addAttribute("home", home);
        return "home/create_home";

    }
    @PostMapping("")
    public String saveHomeModel(@ModelAttribute("home") HomeModel homeModel) {
        homeService.saveHomeModel(homeModel);
        return "redirect:/cms/home";
    }

    @GetMapping("/edit/{id}")
    public String editHomeModel(@PathVariable int id, Model model) {
        model.addAttribute("home", homeService.getHomeModelById(id));
        return "home/edit_home";
    }

    @PostMapping("/{id}")
    public String updateHomeModel(@PathVariable int id,
                             @ModelAttribute("home") HomeModel homeModel,
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
