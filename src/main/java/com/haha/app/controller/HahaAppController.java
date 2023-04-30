package com.haha.app.controller;

import com.haha.app.model.Setup;
import com.haha.app.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/setup")
public class HahaAppController {

    @Autowired
    SetupService setupService;

    @GetMapping("/getAllSetups")
    public ResponseEntity<List<Setup>> getTestData() {
        return ResponseEntity.ok(setupService.getSetups());
    }

}
