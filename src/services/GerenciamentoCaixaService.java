package services;
import java.util.ArrayList;
import java.util.List;

import models.Operacao;


public class GerenciamentoCaixaService {
    private List<Operacao> operacoes = new ArrayList<>();

    public void adicionarOperacao(Operacao operacao) {
        operacoes.add(operacao);
    }

    public List<Operacao> listarOperacaos() {
        return operacoes;
    }
}
