package com.haha.app.repository;

import com.haha.app.model.Like;
import com.haha.app.model.Punchline;
import com.haha.app.model.Setup;
import com.haha.app.model.UserH2;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LikeCrudRepositoryTest {

    @Autowired
    LikeCrudRepository likeCrudRepository;

    @Autowired
    SetupPageAndSortingRepository setupPageAndSortingRepository;

    @Autowired
    PunchlineCrudRepository punchlineCrudRepository;

    @Autowired
    UserCrudRepository userCrudRepository;

    @Test
    public void getAllByUserH2Test(){
        Setup setup = new Setup();
        setup.setText("test setup text");

        Punchline punchline1 = new Punchline();
        punchline1.setText("test punchline text");
        punchlineCrudRepository.save(punchline1);

        Punchline punchline2 = new Punchline();
        punchline2.setText("test punchline text");
        punchlineCrudRepository.save(punchline2);

        setup.getPunchlines().addAll(Set.of(punchline1, punchline2));
        setupPageAndSortingRepository.save(setup);

        UserH2 user = new UserH2();
        userCrudRepository.save(user);

        Like like1 = new Like();
        like1.setUserH2(user);
        punchline1.getLikes().add(like1);
        Like savedLike = likeCrudRepository.save(like1);
        Like savedLike2 = likeCrudRepository.save(like1);


        Like like2 = new Like();
        like2.setUserH2(user);
        punchline2.getLikes().add(like2);

       Set<Like> result = likeCrudRepository.findAllByUserH2(user);

        Assertions.assertEquals(Set.of(savedLike, savedLike2), result);
    }


}
