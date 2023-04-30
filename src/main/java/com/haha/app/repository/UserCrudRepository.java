package com.haha.app.repository;

import com.haha.app.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCrudRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
