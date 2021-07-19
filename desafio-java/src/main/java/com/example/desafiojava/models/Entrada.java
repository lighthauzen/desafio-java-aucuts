package com.example.desafiojava.models;

import com.example.desafiojava.Jogada;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Entrada {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Jogada jogada;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jogador_id", referencedColumnName = "id")
    private Jogador jogador;


}
