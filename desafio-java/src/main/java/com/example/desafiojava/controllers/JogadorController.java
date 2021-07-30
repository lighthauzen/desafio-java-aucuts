package com.example.desafiojava.controllers;

import com.example.desafiojava.models.Entrada;
import com.example.desafiojava.models.Jogador;
import com.example.desafiojava.models.Pontuacao;
import com.example.desafiojava.repositorys.EntradaRepository;
import com.example.desafiojava.repositorys.JogadorRepository;
import com.example.desafiojava.services.ValidacaoServiceImpl;
import com.example.desafiojava.services.ValidacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    ValidacoesService service;

    @GetMapping
    public ResponseEntity listarTodos() {
        List<Jogador> lista = jogadorRepository.findAll();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
    }

    @GetMapping("/comparacao")
    public ResponseEntity comparar() {
        List<Entrada> lista = entradaRepository.findAll();
        Entrada entrada1 = lista.get(0);
        Entrada entrada2 = lista.get(1);
        System.out.println(lista);
//        Entrada resultado = service.comparacao(entrada1, entrada2);
        Pontuacao resultado = service.resultadoFinal();
        System.out.println("result depois do service");
        System.out.println(resultado);

        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(resultado.getJogador().getNome());
    }
}
