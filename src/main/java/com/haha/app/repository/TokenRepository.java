package com.haha.app.repository;

import java.util.List;
import java.util.Optional;

import com.haha.app.model.Token;
import com.haha.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    List<Token> findAllByUser(User user);

    Optional<Token> findByToken(String token);
}
