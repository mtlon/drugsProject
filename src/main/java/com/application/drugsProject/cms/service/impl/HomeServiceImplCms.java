package com.application.drugsProject.cms.service.impl;

import com.application.drugsProject.cms.model.HomeModelCms;
import com.application.drugsProject.cms.repository.HomeRepositoryCms;
import com.application.drugsProject.cms.service.HomeServiceCms;
import com.application.drugsProject.exception.HomeModelNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HomeServiceImplCms implements HomeServiceCms {
    private HomeRepositoryCms homeRepository;

    @Autowired
    public HomeServiceImplCms(HomeRepositoryCms homeRepositoryCms) {
        this.homeRepository = homeRepositoryCms;
    }

    @Override
    public List<HomeModelCms> getAllHomeModels() {
        return homeRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
    @Override
    public HomeModelCms getHomeModelById(int homeModelID) {
        HomeModelCms getHomeModelByID = homeRepository.findById(homeModelID)
                .orElseThrow(()-> new HomeModelNotFoundException("Home model not found"));
        return getHomeModelByID;
    }

    @Override
    public HomeModelCms saveHomeModel(HomeModelCms homeModel) {
        HomeModelCms newHomeModel = new HomeModelCms();
        newHomeModel.setImage(homeModel.getImage());
        newHomeModel.setTitle(homeModel.getTitle());
        newHomeModel.setContent(homeModel.getContent());

        return homeRepository.save(newHomeModel);
    }

    @Override
    public HomeModelCms updateHomeModel(HomeModelCms homeModel, int homeModelID) {
        HomeModelCms updateHomeModelByID = homeRepository.findById(homeModelID)
                .orElseThrow(()-> new HomeModelNotFoundException("Home model not found"));

        updateHomeModelByID.setImage(homeModel.getImage());
        updateHomeModelByID.setTitle(homeModel.getTitle());
        updateHomeModelByID.setContent(homeModel.getContent());

        return homeRepository.save(updateHomeModelByID);
    }

    @Override
    public void deleteHomeModelById(int homeModelID) {
        getHomeModelById(homeModelID);
        homeRepository.deleteById(homeModelID);
    }
}
