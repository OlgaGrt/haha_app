package com.haha.app.controller;

import com.haha.app.model.JokeEnd;
import com.haha.app.model.JokeStart;
import com.haha.app.service.JokeEndService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JokesController {

    @Resource
    JokeEndService jokeEndService;

    @GetMapping("/getAllJokes")
    public List<JokeStart> getTestData() {
        List<JokeStart> result = new ArrayList<>();
        return result;
    }

    @PostMapping("/jokeEnd")
    JokeEnd addJokeEnd(@RequestBody JokeEnd jokeEnd) {
       return jokeEndService.saveJokeEnd(jokeEnd);
    }


}
