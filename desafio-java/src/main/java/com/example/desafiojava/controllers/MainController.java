package com.example.desafiojava.controllers;

import com.example.desafiojava.models.Entrada;
import com.example.desafiojava.models.Jogador;
import com.example.desafiojava.models.Pontuacao;
import com.example.desafiojava.repositorys.EntradaRepository;
import com.example.desafiojava.repositorys.JogadorRepository;
import com.example.desafiojava.repositorys.PontuacaoRepository;
import com.example.desafiojava.services.crud.CrudService;
import com.example.desafiojava.services.validacao.ValidacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class MainController {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private PontuacaoRepository pontuacaoRepository;

    @Autowired
    ValidacoesService validacoesService;

    @Autowired
    CrudService crudService;

    @GetMapping
    public ResponseEntity listarTodos() {
        List<Jogador> lista = jogadorRepository.findAll();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
    }

    @GetMapping("/jogador/comparacao")
    public ResponseEntity comparar() {
        List<Entrada> lista = entradaRepository.findAll();
        Entrada entrada1 = lista.get(0);
        Entrada entrada2 = lista.get(1);
        System.out.println(lista);
//        Entrada resultado = service.comparacao(entrada1, entrada2);
        Pontuacao resultado = validacoesService.resultadoFinal();
        System.out.println("result depois do service");
        System.out.println(resultado);

        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(resultado.getJogador().getNome());
    }

    @PostMapping("/jogador")
    public ResponseEntity criarJogador(@RequestBody Jogador jogador) {
       return crudService.criarJogador(jogador);
    }

    @PostMapping("/entrada")
    public ResponseEntity criarEntrada(@RequestBody Entrada entrada) {
        return crudService.criarEntrada(entrada);
    }

    @PostMapping("/pontuacao")
    public ResponseEntity criarPontuacao(@RequestBody Pontuacao pontuacao) {
        return crudService.criarPontuacao(pontuacao);
    }
}
