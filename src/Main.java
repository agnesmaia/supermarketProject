import java.util.Scanner;

import models.Produto;
import controllers.ProdutoController;
import services.AutenticaçãoService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AutenticaçãoService authService = new AutenticaçãoService();
        ProdutoController produtoController = new ProdutoController();

        System.out.println("Bem-vindo ao Sistema de Supermercado!");

        System.out.print("Digite seu nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        if (authService.autenticarAdministrador(username, senha)) {
            System.out.println("Bem-vindo, Administrador!");

            // operações de administrador
            Produto produto1 = new Produto(1, "Arroz", "Alimentos", 20.0, 100);
            Produto produto2 = new Produto(2, "Feijão", "Alimentos", 10.0, 50);
            produtoController.adicionarProduto(produto1);
            produtoController.adicionarProduto(produto2);

            System.out.println("Produtos disponíveis:");
            produtoController.listarProdutos();

            System.out.println("Atualizando o estoque do produto 1 (Arroz)...");
            produto1.setQuantidadeEmEstoque(90);
            produtoController.atualizarProduto(produto1);

            System.out.println("Produtos após a atualização:");
            produtoController.listarProdutos();

            System.out.println("Removendo o produto 2 (Feijão)...");
            produtoController.removerProduto(2);

            System.out.println("Produtos após a remoção:");
            produtoController.listarProdutos();
        } else if (authService.autenticarCliente(username, senha)) {
            System.out.println("Bem-vindo, Cliente!");
        } else {
            System.out.println("Usuário ou senha inválidos.");
        }

        scanner.close();
    }
}