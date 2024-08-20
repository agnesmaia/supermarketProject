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

    public void atualizarProduto(Produto produtoAtualizado) {
        produtoService.atualizarProduto(produtoAtualizado);
    }

    public void removerProduto(int id) {
        produtoService.removerProduto(id);
    }
}
