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
public class PunchlineCrudRepositoryTest {

    @Autowired
    SetupPageAndSortingRepository setupPageAndSortingRepository;

    @Autowired
    PunchlineCrudRepository punchlineCrudRepository;

    @Autowired
    LikeCrudRepository likeCrudRepository;


    @Test
    public void findAllPunchlinesBySetupOrderByLikesCountTest() {
        Punchline punchlineWithoutLikes = new Punchline();
        punchlineCrudRepository.save(punchlineWithoutLikes);

        Punchline punchlineWithOneLike = new Punchline();
        Like like = new Like();
        likeCrudRepository.save(like);
        punchlineWithOneLike.getLikes().add(like);
        punchlineCrudRepository.save(punchlineWithOneLike);

        Punchline jokeEndWithTwoLikes = new Punchline();
        Like like1 = new Like();
        Like like2 = new Like();
        jokeEndWithTwoLikes.getLikes().addAll(Set.of(like1, like2));
        punchlineCrudRepository.save(jokeEndWithTwoLikes);

        Setup setup = new Setup();
        setup.setPunchlines(Set.of(punchlineWithOneLike, punchlineWithoutLikes, jokeEndWithTwoLikes));
        setupPageAndSortingRepository.save(setup);

        List<Punchline> result = punchlineCrudRepository.findAllPunchlinesBySetupOrderByLikesCount(setup);
        List<Punchline> expectedResult = List.of(jokeEndWithTwoLikes, punchlineWithOneLike, punchlineWithoutLikes);
        Assertions.assertEquals(expectedResult, result);
    }

}
