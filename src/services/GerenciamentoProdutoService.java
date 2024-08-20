package services;
import java.util.ArrayList;
import java.util.List;

import models.Produto;
import models.Categoria;

public class GerenciamentoProdutoService {
    private List<Produto> produtos = new ArrayList<>();
    private List<Categoria> categorias = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public void atualizarProduto(Produto produtoAtualizado) {
        for (Produto produto : produtos) {
            if (produto.getId() == produtoAtualizado.getId()) {
                produto.setQuantidadeEmEstoque(produtoAtualizado.getQuantidadeEmEstoque());
                break;
            }
        }
    }

    public void removerProduto(int id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    public void adicionarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public List<Categoria> listarCategorias() {
        return categorias;
    }
}
