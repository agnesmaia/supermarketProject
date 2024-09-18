package controllers;

import models.Produto;
import services.GerenciamentoProdutoService;

import java.util.List;
public class ProdutoController {
    private GerenciamentoProdutoService produtoService = new GerenciamentoProdutoService();

    public void listarProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        for (Produto produto : produtos) {
            System.out.println("ID: " + produto.getId() + " | Nome: " + produto.getNome() + " | Categoria: " + produto.getCategoria() + " | Preço: R$ " + produto.getPreco() + " | Estoque: " + produto.getQuantidadeEmEstoque());
        }
    }

    public void adicionarProduto(Produto produto) {
        produtoService.adicionarProduto(produto);
    }

    public void adicionarProduto(Produto produto, double taxa) {
        Produto produtoComTaxa = new Produto(produto);
        produtoComTaxa.setPreco(produto.getPreco() * (1 + taxa / 100));
        produtoService.adicionarProduto(produtoComTaxa);
    }

    public boolean produtoExiste(int id) {
        return produtoService.produtoExiste(id);
    }

    public void atualizarPrecoProduto(int id, double preco) {
        produtoService.atualizarPrecoProduto(id, preco);
    }

    public void atualizarEstoqueProduto(int id, int quantidade) {
        produtoService.atualizarPrecoProduto(id, quantidade);
    }

    public void removerProduto(int id) {
        produtoService.removerProduto(id);
    }
}
