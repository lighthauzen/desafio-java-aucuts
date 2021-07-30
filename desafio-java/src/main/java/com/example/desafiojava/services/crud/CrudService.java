package com.example.desafiojava.services.crud;


import com.example.desafiojava.models.Entrada;
import com.example.desafiojava.models.Jogador;
import com.example.desafiojava.models.Pontuacao;
import org.springframework.http.ResponseEntity;

public interface CrudService {

    public abstract ResponseEntity criarJogador(Jogador jogador);
    public abstract ResponseEntity criarEntrada(Entrada entrada);
    public abstract ResponseEntity criarPontuacao(Pontuacao pontuacao);

}
