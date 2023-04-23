package com.haha.app.repository;

import com.haha.app.model.Punchline;
import com.haha.app.model.Setup;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SetupPageAndSortingRepositoryTest {

    @Autowired
    SetupPageAndSortingRepository setupPageAndSortingRepository;
    @Autowired
    PunchlineCrudRepository punchlineCrudRepository;

    @Test
    public void canSaveSetup() {
        Setup setup = new Setup();
        setup.setText("test setup text");
        Setup setupSaved = setupPageAndSortingRepository.save(setup);
        Assertions.assertEquals(setupSaved.getText(), setup.getText());
    }

    @Test
    public void canSaveOnePunchlineToSetup() {
        Setup setup = new Setup();
        setup.setText("test setup text");
        Punchline punchline = new Punchline();
        punchline.setText("test punchline text");
        punchlineCrudRepository.save(punchline);

        setup.getPunchlines().add(punchline);
        Setup setupSaved = setupPageAndSortingRepository.save(setup);
        Assertions.assertEquals(setupSaved.getPunchlines(), Set.of(punchline));
    }

    @Test
    public void canSaveTwoPunchlinesToSetup() {
        Setup setup = new Setup();
        setup.setText("test setup text");

        Punchline punchline1 = new Punchline();
        punchline1.setText("test punchline text 1");
        punchlineCrudRepository.save(punchline1);
        setup.getPunchlines().add(punchline1);

        Punchline punchline2 = new Punchline();
        punchline2.setText("test punchline text 2");
        punchlineCrudRepository.save(punchline2);
        setup.getPunchlines().add(punchline2);

        Setup setupSaved = setupPageAndSortingRepository.save(setup);
        Assertions.assertEquals(setupSaved.getPunchlines(), Set.of(punchline1, punchline2));
    }

    @Test
    public void findAllSortByPunchlinesCountTest() {
        Setup setupWithNoPunchlines = new Setup();
        setupPageAndSortingRepository.save(setupWithNoPunchlines);


        Setup setupWithOnePunchlines = new Setup();

        Punchline punchline = new Punchline();
        punchlineCrudRepository.save(punchline);
        setupWithOnePunchlines.getPunchlines().add(punchline);
        setupPageAndSortingRepository.save(setupWithOnePunchlines);


        Setup setupWithTwoPunchlines = new Setup();
        setupWithTwoPunchlines.setText("test setup text");

        Punchline punchline1 = new Punchline();
        punchline1.setText("test punchline text 1");
        punchlineCrudRepository.save(punchline1);
        setupWithTwoPunchlines.getPunchlines().add(punchline1);

        Punchline punchline2 = new Punchline();
        punchline2.setText("test punchline text 2");
        punchlineCrudRepository.save(punchline2);
        setupWithTwoPunchlines.getPunchlines().add(punchline2);
        setupPageAndSortingRepository.save(setupWithTwoPunchlines);


        Assertions.assertEquals(setupPageAndSortingRepository.findAllSortByPunchlinesCount(),
                List.of(setupWithTwoPunchlines, setupWithOnePunchlines, setupWithNoPunchlines));
    }

}
