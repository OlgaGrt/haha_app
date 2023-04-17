package com.haha.app.repository;

import com.haha.app.model.Setup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public interface SetupPageAndSortingRepository extends JpaRepository<Setup, Long> {

    default List<Setup> findAllSortByPunchlinesCount(){
        List<Setup> all = findAll();
        return all.stream().sorted(byPunchlinesCount.reversed()).collect(Collectors.toList());
    }

    Comparator<Setup> byPunchlinesCount = Comparator.comparingInt((Setup o) -> Optional.ofNullable(o.getPunchlines()).orElse(Collections.EMPTY_SET).size());
}
