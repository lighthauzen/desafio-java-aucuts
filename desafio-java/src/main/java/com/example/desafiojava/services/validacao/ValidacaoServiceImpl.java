package com.example.desafiojava.services.validacao;


import com.example.desafiojava.models.Entrada;
import com.example.desafiojava.models.Jogador;
import com.example.desafiojava.models.Pontuacao;
import com.example.desafiojava.repositorys.EntradaRepository;
import com.example.desafiojava.repositorys.JogadorRepository;
import com.example.desafiojava.repositorys.PontuacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValidacaoServiceImpl implements ValidacoesService {

    @Autowired
    public EntradaRepository entradaRepository;

    @Autowired
    public JogadorRepository jogadorRepository;

    @Autowired
    public PontuacaoRepository pontuacaoRepository;

    @Override
    public Entrada comparacao(Entrada entrada1, Entrada entrada2) {
            String e1String = entrada1.getJogada().toString();
            String e2String = entrada2.getJogada().toString();
            Jogador idE1 = entrada1.getJogador();
            Jogador idE2 = entrada2.getJogador();

        System.out.println("strings validação:");
        System.out.println(e1String );
        System.out.println(e2String );
            Entrada resultado = new Entrada();

            switch (e1String) {
                case "spock":
                    if(e2String == "tesoura" || e2String == "pedra") {
                        resultado =  entrada1;
                        adicionarPontos(idE1);
                    } else {
                        resultado = entrada2;
                        adicionarPontos(idE2);
                    }
                    break;
                case "tesoura":
                    if(e2String == "papel" || e2String == "lagarto") {
                        resultado =  entrada1;
                        adicionarPontos(idE1);
                    } else {
                        resultado = entrada2;
                        adicionarPontos(idE2);
                    }
                    break;
                case "papel":
                    if(e2String == "pedra" || e2String == "spock") {
                        resultado =  entrada1;
                        adicionarPontos(idE1);
                    } else {
                        resultado = entrada2;
                        adicionarPontos(idE2);
                    }
                    break;
                case "pedra":
                    if(e2String == "lagarto" || e2String == "tesoura") {
                        resultado =  entrada1;
                        adicionarPontos(idE1);
                    } else {
                        resultado = entrada2;
                        adicionarPontos(idE2);
                    }
                    break;
                case "lagarto":
                    if(e2String == "spock" || e2String == "papel") {
                        resultado =  entrada1;
                        adicionarPontos(idE1);
                    } else {
                        resultado = entrada2;
                        adicionarPontos(idE2);
                    }
                    break;
            };

        System.out.println("result depois switch");
        System.out.println(resultado);
        return resultado;

    }

    @Override
    public Pontuacao resultadoFinal() {

        List<Entrada> list = entradaRepository.findAll();


        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                comparacao(list.get(i),list.get(j));

            }
        }

        List<Pontuacao> resultado = pontuacaoRepository.findAllByOrderByPontuacaoDesc();
        Pontuacao vencedor = resultado.get(0);

        return vencedor;
    }

    @Override
    public void adicionarPontos(Jogador jogador) {
        Optional<Pontuacao> target = pontuacaoRepository.findByJogador_Id(jogador.getId());
        System.out.println(target);
        if (!target.isEmpty()) {
            Integer pontosAtuais = target.get().getPontuacao();
            Integer pontosFinais = pontosAtuais + 1;
            target.get().setPontuacao(pontosFinais);
            pontuacaoRepository.save(target.get());
        } else {
            Pontuacao novaPontuacao = new Pontuacao();
            novaPontuacao.setPontuacao(1);
            novaPontuacao.setJogador(jogador);
            pontuacaoRepository.save(novaPontuacao);
        }
    }
}
