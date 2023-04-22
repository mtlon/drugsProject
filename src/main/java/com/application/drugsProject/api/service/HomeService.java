package com.application.drugsProject.api.service;

import com.application.drugsProject.api.model.HomeModel;

import java.util.List;

public interface HomeService {
    List<HomeModel> getAllHomeModels();
    HomeModel saveHomeModel(HomeModel homeModel);
    HomeModel getHomeModelById(int homeModelID);
    HomeModel updateHomeModel(HomeModel homeModel, int homeModelID);
    void deleteHomeModelById(int homeModelID);
}
