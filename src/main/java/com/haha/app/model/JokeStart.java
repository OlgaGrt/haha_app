package com.haha.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity(name = "joke_start")
@Getter
@Setter
@NoArgsConstructor
public class JokeStart {
    @Id
    @GeneratedValue
    private Long id;

    String jokeStartText;

    @OneToMany(cascade = {CascadeType.ALL})
    private Set<JokeEnd> jokeEnds;
}
