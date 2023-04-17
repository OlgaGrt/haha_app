package com.haha.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "userH2")
@Getter
@Setter
@NoArgsConstructor
public class UserH2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    String email;
    String password;
}
