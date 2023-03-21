package com.application.drugsProject.controller;

import com.application.drugsProject.model.Drug;
import com.application.drugsProject.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drugs")
public class DrugController {
    private DrugService drugService;

    @Autowired
    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }
    @GetMapping("")
    public ResponseEntity<List<Drug>> getAllDrugs() {
        return new ResponseEntity<>(drugService.getAllDrugs(), HttpStatus.OK);
    }
    @GetMapping("/test")
    public ResponseEntity<String> getTest() {
        return new ResponseEntity<>("1", HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<Drug> addDrug(@RequestBody Drug drug) {
        Drug newDrug = drugService.newDrag(drug);
        return new ResponseEntity<>(newDrug, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Drug> updateDrug(@RequestBody Drug drug, @PathVariable("id") int id) {
        Drug updateDrug = drugService.updateDrug(drug, id);
        return new ResponseEntity<>(updateDrug, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDrug(@PathVariable("id") int id) {
        drugService.deleteDrug(id);
        return new ResponseEntity<>("Drug deleted successfully", HttpStatus.OK);
    }
}
