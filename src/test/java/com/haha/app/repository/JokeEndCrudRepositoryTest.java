package com.haha.app.repository;

import com.haha.app.model.Punchline;
import com.haha.app.model.Setup;
import com.haha.app.model.Like;
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
public class JokeEndCrudRepositoryTest {

    @Autowired
    SetupPageAndSortingRepository setupPageAndSortingRepository;

    @Autowired
    PunchlineCrudRepository punchlineCrudRepository;

    @Test
    public void myTest() {
        Setup setup = new Setup();
        Setup jokeStartSaved = setupPageAndSortingRepository.save(setup);

        Punchline punchlineWithoutLikes = new Punchline();
        punchlineWithoutLikes.setSetup(setup);
        punchlineCrudRepository.save(punchlineWithoutLikes);

        Punchline punchlineWithOneLike = new Punchline();
        Like like = new Like();
        punchlineWithOneLike.setLikes(Set.of(like));
        punchlineWithOneLike.setSetup(setup);
        punchlineCrudRepository.save(punchlineWithOneLike);

        Punchline jokeEndWithTwoLikes = new Punchline();
        Like like1 = new Like();
        Like like2 = new Like();
        jokeEndWithTwoLikes.setLikes(Set.of(like1, like2));
        jokeEndWithTwoLikes.setSetup(setup);
        punchlineCrudRepository.save(jokeEndWithTwoLikes);

        setup.setPunchlines(Set.of(punchlineWithOneLike, punchlineWithoutLikes, jokeEndWithTwoLikes)); // explicitly set to two object in relation

        List<Punchline> result = punchlineCrudRepository.findAllPunchlinesBySetupOrderByLikesCount(jokeStartSaved.getId());
        List<Punchline> expectedResult = List.of(jokeEndWithTwoLikes, punchlineWithOneLike, punchlineWithoutLikes);
        Assertions.assertEquals(expectedResult, result);
    }

}
