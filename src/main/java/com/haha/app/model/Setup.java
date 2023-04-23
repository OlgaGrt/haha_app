package com.haha.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "setup")
@Getter
@Setter
@NoArgsConstructor
public class Setup {
    @Id
    @GeneratedValue
    private Long id;

    String text;

    @OneToMany
    Set<Punchline> punchlines = new HashSet<>();
}
