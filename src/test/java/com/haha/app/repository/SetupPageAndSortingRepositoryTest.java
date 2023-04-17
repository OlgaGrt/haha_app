package com.haha.app.repository;

import com.haha.app.model.Punchline;
import com.haha.app.model.Setup;
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
public class SetupPageAndSortingRepositoryTest {

    @Autowired
    SetupPageAndSortingRepository jokeStartPageAndSortingRepository;

    @Test
    public void myTest() {
        Setup setup = new Setup();
        Setup setupSaved = jokeStartPageAndSortingRepository.save(setup);
        Assertions.assertEquals(setup.getText(), setupSaved.getText());
    }

    @Test
    public void findAllSortByJokeEndsCount() {
        Setup setupWithoutPunchlines = new Setup();
        jokeStartPageAndSortingRepository.save(setupWithoutPunchlines);

        Setup setupWithOnePunchline = new Setup();
        Punchline punchline = new Punchline();
        punchline.setSetup(setupWithOnePunchline);
        setupWithOnePunchline.setPunchlines(Set.of(punchline));
        jokeStartPageAndSortingRepository.save(setupWithOnePunchline);

        Setup setupWithTwoPunchlines = new Setup();
        Punchline punchline1 = new Punchline();
        Punchline punchline2 = new Punchline();
        punchline1.setSetup(setupWithTwoPunchlines);
        punchline2.setSetup(setupWithTwoPunchlines);
        setupWithTwoPunchlines.setPunchlines(Set.of(punchline1, punchline2));
        jokeStartPageAndSortingRepository.save(setupWithTwoPunchlines);

        List<Setup> result = jokeStartPageAndSortingRepository.findAllSortByPunchlinesCount();
        List<Setup> expectedResult = List.of(setupWithTwoPunchlines, setupWithOnePunchline, setupWithoutPunchlines);
        Assertions.assertEquals(expectedResult, result);
    }
}
