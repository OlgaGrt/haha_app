package com.haha.app.repository;

import com.haha.app.model.Like;
import com.haha.app.model.UserH2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface LikeCrudRepository extends CrudRepository<Like, Long> {

    Set<Like> findAllByUserH2(UserH2 userH2);
}
