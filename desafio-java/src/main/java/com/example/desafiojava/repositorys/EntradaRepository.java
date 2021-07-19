package com.example.desafiojava.repositorys;

import com.example.desafiojava.models.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntradaRepository extends JpaRepository<Entrada, Integer> {
}
