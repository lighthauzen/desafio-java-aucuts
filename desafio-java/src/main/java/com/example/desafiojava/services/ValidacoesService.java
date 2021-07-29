package com.example.desafiojava.services;


import com.example.desafiojava.models.Entrada;
import org.springframework.stereotype.Service;


public interface ValidacoesService {


    public abstract Entrada resultado(Entrada entrada1, Entrada entrada2);
    public abstract Entrada comparacao(Entrada entrada1, Entrada entrada2);

}
