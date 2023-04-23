package com.haha.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "punchline")
@Getter @Setter @NoArgsConstructor
public class Punchline {

    @Id
    @GeneratedValue
    private Long id;

    String text;

    @OneToMany
    Set<Like> likes = new HashSet<>();
}
