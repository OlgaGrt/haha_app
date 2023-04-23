package com.haha.app.repository;

import com.haha.app.model.Like;
import com.haha.app.model.Punchline;
import com.haha.app.model.Setup;
import com.haha.app.model.UserH2;
import org.h2.engine.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserCrudRepositoryTest {

    @Autowired
    UserCrudRepository userCrudRepository;

    @Autowired
    SetupPageAndSortingRepository setupPageAndSortingRepository;

    @Autowired
    PunchlineCrudRepository punchlineCrudRepository;

    @Test
    public void getAllUserPunchlines() {
        Setup setup = new Setup();
        setup.setText("test setup text");
        Punchline punchline = new Punchline();
        punchline.setText("test punchline text");
        punchlineCrudRepository.save(punchline);

        setup.getPunchlines().add(punchline);
        Setup setupSaved = setupPageAndSortingRepository.save(setup);


        UserH2 user = new UserH2();
        Like like = new Like();



    }
}
