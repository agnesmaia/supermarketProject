package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Produto;

public class FornecedorService {
    private List<Produto> produtos = new ArrayList<>();

    public void carregarProdutos(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            boolean primeiraLinha = true;
            
            while ((linha = br.readLine()) != null) {
                // Ignora a primeira linha (cabeçalho)
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                // Divide a linha em campos
                String[] campos = linha.split(",");
                
                // Verifica se a linha tem o número correto de campos, ignorando produtos com falta de informação
                if (campos.length == 4) {
                    int id = Integer.parseInt(campos[0]);
                    String nome = campos[1];
                    String categoria = campos[2];
                    double preco = Double.parseDouble(campos[3]);
                    int quantidadeEmEstoque = 1000;

                    // Cria um objeto Produto e o adiciona à lista
                    Produto produto = new Produto(id, nome, categoria, preco, quantidadeEmEstoque);
                    produtos.add(produto);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void exibirProdutos() {
        for (Produto produto : produtos) {
            System.out.println("ID: " + produto.getId() + " | Nome: " + produto.getNome() + " | Categoria: " + produto.getCategoria() + " | Preço: R$ " + produto.getPreco() + " | Estoque: " + produto.getQuantidadeEmEstoque());
        }
    }

    public Produto fornecerProduto(int id, int quantidade) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.setQuantidadeEmEstoque(quantidade);
                return produto;
            }
        }
        return null;
    }

    public Produto fornecerProduto(String nome, int quantidade) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                produto.setQuantidadeEmEstoque(quantidade);
                return produto;
            }
        }
        return null;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}