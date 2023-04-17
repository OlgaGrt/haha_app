package com.haha.app.service;

import com.haha.app.model.Punchline;
import com.haha.app.model.Setup;
import com.haha.app.repository.PunchlineCrudRepository;
import com.haha.app.repository.SetupPageAndSortingRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JokeEndService {
    @Resource
    PunchlineCrudRepository jokeEndRepository;

    @Resource
    SetupPageAndSortingRepository jokeStartPageAndSortingRepository;

    public Punchline saveJokeEnd(final Punchline jokeEnd){
        return jokeEndRepository.save(jokeEnd);
    }

    public List<Setup> findAllJokesStart(){
        return jokeStartPageAndSortingRepository.findAllSortByPunchlinesCount();
    }

}
