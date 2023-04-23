package com.haha.app.repository;

import com.haha.app.model.UserH2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrudRepository extends CrudRepository<UserH2, Long> {


}
