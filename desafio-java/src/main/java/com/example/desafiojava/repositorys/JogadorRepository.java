package com.example.desafiojava.repositorys;

import com.example.desafiojava.models.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
}
