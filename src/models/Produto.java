package models;

public class Produto {
    private int id;
    private String nome;
    private String categoria;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(int id, String nome, String categoria, double preco, int quantidadeEmEstoque) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Produto(Produto outro) {
        this.id = outro.id;
        this.nome = outro.nome;
        this.categoria = outro.categoria;
        this.preco = outro.preco;
        this.quantidadeEmEstoque = outro.quantidadeEmEstoque;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
}
