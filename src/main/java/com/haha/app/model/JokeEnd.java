package com.haha.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "joke_end")
@Getter @Setter @NoArgsConstructor
public class JokeEnd {

    @Id
    @GeneratedValue
    @Column(name = "joke_end_id")
    private Long id;

    String jokeEndText;

    @ManyToOne
    private JokeStart jokeStart;
}
