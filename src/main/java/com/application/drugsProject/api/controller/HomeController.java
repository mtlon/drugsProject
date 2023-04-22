package com.application.drugsProject.api.controller;

import com.application.drugsProject.api.model.HomeModel;
import com.application.drugsProject.api.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/home")
public class HomeController {
    private HomeService homeService;
    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }
    @GetMapping("")
    public ResponseEntity<List<HomeModel>> homeModelList() {
        List<HomeModel> homeModelList = homeService.getAllHomeModels();
        return new ResponseEntity<>(homeModelList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HomeModel> getHomeModelByID(@PathVariable("id") int homeModelID) {
        HomeModel homeModel = homeService.getHomeModelById(homeModelID);
        return new ResponseEntity<>(homeModel, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<HomeModel> createHomeModel(@RequestBody HomeModel homeModel) {
        HomeModel newHomeModel = homeService.saveHomeModel(homeModel);
        return new ResponseEntity<>(newHomeModel, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<HomeModel> updateHomeModel(@RequestBody HomeModel homeModel, @PathVariable("id") int homeModelID) {
        HomeModel updateHomeModel = homeService.updateHomeModel(homeModel, homeModelID);
        return new ResponseEntity<>(updateHomeModel, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHomeModel(@PathVariable("id") int homeModelID) {
        homeService.deleteHomeModelById(homeModelID);
        return new ResponseEntity<>("Home model deleted successfully", HttpStatus.OK);
    }
}
