package com.haha.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity(name = "punchline")
@Getter @Setter @NoArgsConstructor
public class Punchline {

    @Id
    @GeneratedValue
    @Column(name = "punchline_id")
    private Long id;

    String text;

    @ManyToOne
    private Setup setup;

    @OneToMany(cascade = {CascadeType.ALL})
    private Set<Like> likes;
}
