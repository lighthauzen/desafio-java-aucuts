package com.example.desafiojava.services;


import com.example.desafiojava.models.Entrada;
import com.example.desafiojava.models.Jogador;
import com.example.desafiojava.models.Pontuacao;
import org.springframework.stereotype.Service;


public interface ValidacoesService {

    public abstract Entrada comparacao(Entrada entrada1, Entrada entrada2);
    public abstract Pontuacao resultadoFinal();
    public abstract void adicionarPontos(Jogador jogador);

}
