package com.haha.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "likes")
@Getter
@Setter
@NoArgsConstructor
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private Punchline punchline;

    @ManyToOne
    private UserH2 user;

}
