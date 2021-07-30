package com.example.desafiojava.services.crud;

import com.example.desafiojava.models.Entrada;
import com.example.desafiojava.models.Jogador;
import com.example.desafiojava.models.Pontuacao;
import com.example.desafiojava.repositorys.EntradaRepository;
import com.example.desafiojava.repositorys.JogadorRepository;
import com.example.desafiojava.repositorys.PontuacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CrudServiceImpl implements CrudService{

    @Autowired
    public EntradaRepository entradaRepository;

    @Autowired
    public JogadorRepository jogadorRepository;

    @Autowired
    public PontuacaoRepository pontuacaoRepository;

    @Override
    public ResponseEntity criarJogador(Jogador jogador) {
        if (jogador == null) {
            return ResponseEntity.badRequest().build();
        } else {
            this.jogadorRepository.save(jogador);
            return ResponseEntity.status(HttpStatus.CREATED).body(jogador);
        }
    }

    @Override
    public ResponseEntity criarEntrada(Entrada entrada) {
        if (entrada == null) {
            return ResponseEntity.badRequest().build();
        } else {
            this.entradaRepository.save(entrada);
            return ResponseEntity.status(HttpStatus.CREATED).body(entrada);
        }
    }

    @Override
    public ResponseEntity criarPontuacao(Pontuacao pontuacao) {
        if (pontuacao == null) {
            return ResponseEntity.badRequest().build();
        } else {
            this.pontuacaoRepository.save(pontuacao);
            return ResponseEntity.status(HttpStatus.CREATED).body(pontuacao);
        }
    }
}
