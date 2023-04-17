package com.haha.app.repository;

import com.haha.app.model.Punchline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public interface PunchlineCrudRepository extends CrudRepository<Punchline, Long> {

    List<Punchline> findBySetupId(final Long id);

    default List<Punchline> findAllPunchlinesBySetupOrderByLikesCount(final Long id){
        List<Punchline> all = findBySetupId(id);
        return all.stream().sorted(byPunchlineLikesCount.reversed()).collect(Collectors.toList());
    }
    Comparator<Punchline> byPunchlineLikesCount = Comparator.comparingInt((Punchline o) -> Optional.ofNullable(o.getLikes()).orElse(Collections.EMPTY_SET).size());

}
