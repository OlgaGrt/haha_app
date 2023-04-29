package com.haha.app.service;

import com.haha.app.model.Setup;
import com.haha.app.repository.SetupPageAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultSetupService implements SetupService{

    @Autowired
    SetupPageAndSortingRepository setupPageAndSortingRepository;

    @Override
    public List<Setup> getSetups() {
        return setupPageAndSortingRepository.findAllSortByPunchlinesCount();
    }
}
