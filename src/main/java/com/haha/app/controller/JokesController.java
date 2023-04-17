package com.haha.app.controller;

import com.haha.app.model.Punchline;
import com.haha.app.model.Setup;
import com.haha.app.service.JokeEndService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JokesController {

    @Resource
    JokeEndService jokeEndService;

    @GetMapping("/getAllSetups")
    public List<Setup> getTestData() {
        List<Setup> result = new ArrayList<>();
        return result;
    }

    @PostMapping("/puncline")
    Punchline addPunchline(@RequestBody Punchline punchline) {
       return jokeEndService.saveJokeEnd(punchline);
    }


}
