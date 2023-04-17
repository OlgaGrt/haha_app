package com.haha.app.repository;

import com.haha.app.model.JokeStart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public interface JokeStartPageAndSortingRepository extends JpaRepository<JokeStart, Long> {

    default List<JokeStart> findAllSortByEndsCount(){
        List<JokeStart> all = findAll();
        return all.stream().sorted(byJokeEndsCount.reversed()).collect(Collectors.toList());
    }

    Comparator<JokeStart> byJokeEndsCount = Comparator.comparingInt((JokeStart o) -> Optional.ofNullable(o.getJokeEnds()).orElse(Collections.EMPTY_SET).size());
}
