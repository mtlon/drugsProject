package com.application.drugsProject.api.controller;

import com.application.drugsProject.api.model.DrugModel;
import com.application.drugsProject.api.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("")
public class DrugController {
    private DrugService drugService;
    @Autowired
    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }
    @GetMapping("/drugs")
    public ResponseEntity<List<DrugModel>> drugsList() {
        List<DrugModel> drugList = drugService.getDrugsList();
        return new ResponseEntity<>(drugList, HttpStatus.OK);
    }

    @GetMapping("/drug/{id}")
    public ResponseEntity<DrugModel> getDrugByID(@PathVariable("id") long drugID) {
        DrugModel drug = drugService.getDrugById(drugID);
        return new ResponseEntity<>(drug, HttpStatus.OK);
    }

    @PostMapping("/drug")
    public ResponseEntity<DrugModel> createDrug(@RequestBody DrugModel drugModel) {
        DrugModel drug = drugService.createDrug(drugModel);
        return new ResponseEntity<>(drug, HttpStatus.CREATED);
    }
    @PutMapping("/drug/{id}")
    public ResponseEntity<DrugModel> updateDrug(@RequestBody DrugModel drugModel, @PathVariable("id") long drugID) {
        DrugModel drug = drugService.updateDrug(drugModel, drugID);
        return new ResponseEntity<>(drug, HttpStatus.OK);
    }
    @DeleteMapping("/drug/{id}")
    public ResponseEntity<String> deleteDrug(@PathVariable("id") long drugID) {
        drugService.deleteDrug(drugID);
        return new ResponseEntity<>("Drug deleted successfully", HttpStatus.OK);
    }
}
