package com.application.drugsProject.controller.APIcontroller;

import com.application.drugsProject.model.DrugModel;
import com.application.drugsProject.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("")
public class DrugControllerAPI {
    private DrugService drugService;
    @Autowired
    public DrugControllerAPI(DrugService drugService) {
        this.drugService = drugService;
    }
    @GetMapping("/drugs")
    public ResponseEntity<List<DrugModel>> drugsList() {
        List<DrugModel> drugList = drugService.getDrugsList();
        return new ResponseEntity<>(drugList, HttpStatus.OK);
    }

    @GetMapping("/drug/{id}")
    public ResponseEntity<DrugModel> getDrugByID(@PathVariable("id") int drugID) {
        DrugModel drug = drugService.getDrugById(drugID);
        return new ResponseEntity<>(drug, HttpStatus.OK);
    }

    @PostMapping("/drug")
    public ResponseEntity<DrugModel> createDrug(@RequestBody DrugModel drugModel) {
        DrugModel drug = drugService.createDrug(drugModel);
        return new ResponseEntity<>(drug, HttpStatus.CREATED);
    }
    @PutMapping("/drug/{id}")
    public ResponseEntity<DrugModel> updateDrug(@RequestBody DrugModel drugModel, @PathVariable("id") int drugID) {
        DrugModel drug = drugService.updateDrug(drugModel, drugID);
        return new ResponseEntity<>(drug, HttpStatus.OK);
    }
    @DeleteMapping("/drug/{id}")
    public ResponseEntity<String> deleteDrug(@PathVariable("id") int drugID) {
        drugService.deleteDrug(drugID);
        return new ResponseEntity<>("Drug deleted successfully", HttpStatus.OK);
    }
}
