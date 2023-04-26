package com.application.drugsProject.service.impl;

import com.application.drugsProject.exception.UserModelNotFoundException;
import com.application.drugsProject.model.UserModel;
import com.application.drugsProject.repository.UserRepository;
import com.application.drugsProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> getAllUserModels() {
        List<UserModel> drugs = userRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return drugs.stream().toList();
    }

    @Override
    public UserModel getUserModelById(int userModelID) {
        UserModel userModel = userRepository.findById(userModelID)
                .orElseThrow(() -> new UserModelNotFoundException("User was not found in database"));
        return userModel;
    }

    @Override
    public UserModel saveUserModel(UserModel userModel) {
        UserModel user = new UserModel();
        user.setUsername(userModel.getUsername());
        user.setPassword(userModel.getPassword());

        return userRepository.save(user);
    }

    @Override
    public UserModel updateUserModel(UserModel userModel, int userModelID) {
        UserModel updateUserModel = userRepository.findById(userModelID)
                .orElseThrow(() -> new UserModelNotFoundException("User was not found in database"));

        updateUserModel.setUsername(userModel.getUsername());
        updateUserModel.setPassword(userModel.getPassword());

        return userRepository.save(updateUserModel);
    }

    @Override
    public void deleteUserModelById(int userModelID) {
        getUserModelById(userModelID);
        userRepository.deleteById(userModelID);
    }
}
