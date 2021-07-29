package com.example.desafiojava.repositorys;

import com.example.desafiojava.models.Pontuacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PontuacaoRepository extends JpaRepository<Pontuacao, Integer> {
}
