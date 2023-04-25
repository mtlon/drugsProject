package com.application.drugsProject.controller.APIcontroller;

import com.application.drugsProject.model.UserModel;
import com.application.drugsProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/user")
public class UserControllerAPI {
    private UserService userService;

    @Autowired
    public UserControllerAPI(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserModel>> userModelList() {
        List<UserModel> userModelList = userService.getAllUserModels();
        return new ResponseEntity<>(userModelList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserModelByID(@PathVariable("id") int userModelID) {
        UserModel userModel = userService.getUserModelById(userModelID);
        return new ResponseEntity<>(userModel, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<UserModel> createUserModel(@RequestBody UserModel userModel) {
        UserModel newUserModel = userService.saveUserModel(userModel);
        return new ResponseEntity<>(newUserModel, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> updateUserModel(@RequestBody UserModel userModel, @PathVariable("id") int userModelID) {
        UserModel updateUserModel = userService.updateUserModel(userModel, userModelID);
        return new ResponseEntity<>(updateUserModel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserModel(@PathVariable("id") int userModelID) {
        userService.deleteUserModelById(userModelID);
        return new ResponseEntity<>("User model was deleted successfully", HttpStatus.OK);
    }
}
