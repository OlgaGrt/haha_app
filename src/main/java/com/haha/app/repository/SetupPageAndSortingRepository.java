package com.haha.app.repository;

import com.haha.app.model.Setup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public interface SetupPageAndSortingRepository extends JpaRepository<Setup, Long> {

    default List<Setup> findAllSortByPunchlinesCount(){
        return findAll().stream()
                .sorted(byPunchlinesCount.reversed())
                .collect(Collectors.toList());
    }

    Comparator<Setup> byPunchlinesCount = Comparator.comparingInt((Setup o) -> o.getPunchlines().size());
}
