package com.haha.app.service;

import com.haha.app.model.JokeEnd;
import com.haha.app.model.JokeStart;
import com.haha.app.repository.JokeEndCrudRepository;
import com.haha.app.repository.JokeStartPageAndSortingRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JokeEndService {
    @Resource
    JokeEndCrudRepository jokeEndRepository;

    @Resource
    JokeStartPageAndSortingRepository jokeStartPageAndSortingRepository;

    public JokeEnd saveJokeEnd(final JokeEnd jokeEnd){
        return jokeEndRepository.save(jokeEnd);
    }

    public List<JokeStart> findAllJokesStart(){
        return jokeStartPageAndSortingRepository.findAllSortByEndsCount();
    }

}
