package com.application.drugsProject.controller.CMScontroller;

import com.application.drugsProject.model.HomeModel;
import com.application.drugsProject.model.UserModel;
import com.application.drugsProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cms/user")
public class UserControllerCMS {
    private UserService userService;

    @Autowired
    public UserControllerCMS(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String listUserModels(Model model) {
        model.addAttribute("user", userService.getAllUserModels());
        return "user";
    }
    @GetMapping("/new")
    public String createUserModel(Model model) {
        UserModel user = new UserModel();
        model.addAttribute("user", user);
        return "create_user";
    }
    @PostMapping("")
    public String saveUserModel(@ModelAttribute("user") UserModel userModel) {
        userService.saveUserModel(userModel);
        return "redirect:/cms/user";
    }
    @GetMapping("/edit/{id}")
    public String editUserModel(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUserModelById(id));
        return "edit_user";
    }
    @PostMapping("/{id}")
    public String updateUserModel(@PathVariable int id,
                                  @ModelAttribute("user") UserModel userModel,
                                  Model model) {
        userService.updateUserModel(userModel, id);
        return "redirect:/cms/user";
    }

    @GetMapping("/{id}")
    public String deleteUserModel(@PathVariable int id) {
        userService.deleteUserModelById(id);
        return "redirect:/cms/user";
    }
}
