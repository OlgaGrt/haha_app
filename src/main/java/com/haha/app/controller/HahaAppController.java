package com.haha.app.controller;

import com.haha.app.model.Setup;
import com.haha.app.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/v1/web")
public class HahaAppController {

    @Autowired
    SetupService setupService;

    @GetMapping("/webPage")
    public String getWebPage(final Model model) {
        List<Setup> allSetups = setupService.getSetups();
        model.addAttribute("setups", allSetups);
        return "webPage";
    }
}
