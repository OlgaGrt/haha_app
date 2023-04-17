package com.haha.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToMany(cascade = {CascadeType.ALL})
    private Set<Punchline> punchlines;
}
