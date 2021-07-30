package com.example.desafiojava.repositorys;

import com.example.desafiojava.models.Pontuacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PontuacaoRepository extends JpaRepository<Pontuacao, Integer> {

    Optional<Pontuacao> findByJogador_Id(Integer id);
    List<Pontuacao> findAllByOrderByPontuacaoDesc();
}
