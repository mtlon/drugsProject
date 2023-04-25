package com.application.drugsProject.service;

import com.application.drugsProject.model.DrugModel;
import com.application.drugsProject.model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> getAllUserModels();
    UserModel saveUserModel(UserModel userModel);
    UserModel getUserModelById(int userModelID);
    UserModel updateUserModel(UserModel userModel, int userModelID);
    void deleteUserModelById(int userModelID);
}
