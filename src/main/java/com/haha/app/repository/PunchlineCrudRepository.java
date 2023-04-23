package com.haha.app.repository;

import com.haha.app.model.Punchline;
import com.haha.app.model.Setup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface PunchlineCrudRepository extends CrudRepository<Punchline, Long> {

    default List<Punchline> findAllPunchlinesBySetupOrderByLikesCount(Setup setup){
        return setup.getPunchlines().stream()
                .sorted(byPunchlineLikesCount.reversed()).collect(Collectors.toList());
    }

    Comparator<Punchline> byPunchlineLikesCount = Comparator.comparingInt((Punchline o) -> o.getLikes().size());

}
