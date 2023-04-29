package com.haha.app.controller;

import com.haha.app.model.Setup;
import com.haha.app.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    SetupService setupService;

    @GetMapping("/getAllSetups")
    public List<Setup> getTestData() {
        return setupService.getSetups();
    }

}
