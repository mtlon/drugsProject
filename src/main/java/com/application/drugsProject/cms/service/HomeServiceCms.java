package com.application.drugsProject.cms.service;

import com.application.drugsProject.cms.model.HomeModelCms;

import java.util.List;

public interface HomeServiceCms {
    List<HomeModelCms> getAllHomeModels();
    HomeModelCms saveHomeModel(HomeModelCms homeModel);
    HomeModelCms getHomeModelById(int homeModelID);
    HomeModelCms updateHomeModel(HomeModelCms homeModel, int homeModelID);
    void deleteHomeModelById(int homeModelID);
}
