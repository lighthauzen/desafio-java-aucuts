package com.example.desafiojava.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name ="Pontuacao")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pontuacao {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Jogador jogador;

    private Integer pontuacao;
}
