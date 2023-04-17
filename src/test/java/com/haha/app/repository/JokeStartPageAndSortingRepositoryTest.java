package com.haha.app.repository;

import com.haha.app.model.JokeEnd;
import com.haha.app.model.JokeStart;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JokeStartPageAndSortingRepositoryTest{

    @Autowired
    JokeStartPageAndSortingRepository jokeStartPageAndSortingRepository;

    @Test
    public void myTest() {
        JokeStart jokeStart = new JokeStart();
        jokeStart.setJokeStartText("Многие под старость задумываются, будет ли жизнь после смерти. Что я могу им сказать?");
        JokeStart jokeStartSaved = jokeStartPageAndSortingRepository.save(jokeStart);
        Assertions.assertEquals(jokeStart.getJokeStartText(), jokeStartSaved.getJokeStartText());
    }

    @Test
    public void findAllSortByJokeEndsCount() {
        // jokeStartNoJokeEnds
        JokeStart jokeStartNoJokeEnds = new JokeStart();
        jokeStartNoJokeEnds.setJokeStartText("Многие под старость задумываются, будет ли жизнь после смерти. Что я могу им сказать?");
        jokeStartPageAndSortingRepository.save(jokeStartNoJokeEnds);

        // jokeStartWithOneJokeEnd
        JokeStart jokeStartWithOneJokeEnd = new JokeStart();
        jokeStartWithOneJokeEnd.setJokeStartText("Многие под старость задумываются, будет ли жизнь после смерти. Что я могу им сказать?");
        JokeEnd jokeEnd = new JokeEnd();
        jokeEnd.setJokeStart(jokeStartWithOneJokeEnd);
        jokeEnd.setJokeEndText("answer");
        jokeStartWithOneJokeEnd.setJokeEnds(Set.of(jokeEnd));
        jokeStartPageAndSortingRepository.save(jokeStartWithOneJokeEnd);

        // jokeStartWithOneJokeEnd
        JokeStart jokeStartWithTwoJokeEnd = new JokeStart();
        jokeStartWithTwoJokeEnd.setJokeStartText("Многие под старость задумываются, будет ли жизнь после смерти. Что я могу им сказать?");
        JokeEnd jokeEnd1 = new JokeEnd();
        jokeEnd1.setJokeStart(jokeStartWithOneJokeEnd);
        jokeEnd1.setJokeEndText("answer1");
        JokeEnd jokeEnd2 = new JokeEnd();
        jokeEnd2.setJokeStart(jokeStartWithOneJokeEnd);
        jokeEnd2.setJokeEndText("answer2");
        jokeStartWithTwoJokeEnd.setJokeEnds(Set.of(jokeEnd1, jokeEnd2));
        jokeStartPageAndSortingRepository.save(jokeStartWithTwoJokeEnd);

        List<JokeStart> result = jokeStartPageAndSortingRepository.findAllSortByEndsCount();
        List<JokeStart> expectedResult = List.of(jokeStartWithTwoJokeEnd, jokeStartWithOneJokeEnd, jokeStartNoJokeEnds);
        Assertions.assertEquals(expectedResult, result);
    }
}
