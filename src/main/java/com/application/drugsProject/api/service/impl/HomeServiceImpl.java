package com.application.drugsProject.api.service.impl;

import com.application.drugsProject.api.model.HomeModel;
import com.application.drugsProject.api.repository.HomeRepository;
import com.application.drugsProject.api.service.HomeService;
import com.application.drugsProject.exception.HomeModelNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {
    private HomeRepository homeRepository;

    @Autowired
    public HomeServiceImpl(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    @Override
    public List<HomeModel> getAllHomeModels() {
        return homeRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
    @Override
    public HomeModel getHomeModelById(int homeModelID) {
        HomeModel getHomeModelByID = homeRepository.findById(homeModelID)
                .orElseThrow(()-> new HomeModelNotFoundException("Home model not found"));
        return getHomeModelByID;
    }

    @Override
    public HomeModel saveHomeModel(HomeModel homeModel) {
        HomeModel newHomeModel = new HomeModel();
        newHomeModel.setImage(homeModel.getImage());
        newHomeModel.setTitle(homeModel.getTitle());
        newHomeModel.setContent(homeModel.getContent());

        return homeRepository.save(newHomeModel);
    }

    @Override
    public HomeModel updateHomeModel(HomeModel homeModel, int homeModelID) {
        HomeModel updateHomeModelByID = homeRepository.findById(homeModelID)
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
