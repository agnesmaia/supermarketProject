package controllers;

import models.Operacao;
import models.Produto;
import services.GerenciamentoCaixaService;

import java.util.List;
public class CaixaController {
    private GerenciamentoCaixaService caixaService = new GerenciamentoCaixaService();

    public void listarOperacaos() {
        List<Operacao> operacaos = caixaService.listarOperacaos();
        for (Operacao operacao : operacaos) {
            System.out.println("Valor: R$ " + operacao.getValor() + " | Tipo: " + operacao.getTipo());
        }
    }

    public void adicionarOperacao(Operacao operacao) {
        caixaService.adicionarOperacao(operacao);
    }

    public void adicionarOperacao(double valor, String tipo) {
        caixaService.adicionarOperacao(new Operacao(valor, tipo));
    }

    public void adicionarOperacao(Produto produto, String tipo) {
        caixaService.adicionarOperacao(new Operacao(produto.getPreco() * produto.getQuantidadeEmEstoque(), tipo));
    }
}
