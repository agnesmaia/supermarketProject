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

    public void atualizarPrecoProduto(int id, double preco) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.setPreco(preco);
                break;
            }
        }
    }

    public void atualizarEstoqueProduto(int id, int quantidade) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() + quantidade);
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

    public boolean produtoExiste(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public List<Categoria> listarCategorias() {
        return categorias;
    }
}
