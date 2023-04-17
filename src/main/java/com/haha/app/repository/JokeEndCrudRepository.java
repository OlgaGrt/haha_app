package com.haha.app.repository;

import com.haha.app.model.JokeEnd;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokeEndCrudRepository extends CrudRepository<JokeEnd, Long> {
}
