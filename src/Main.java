import java.util.Scanner;

import controllers.ProdutoController;
import controllers.CaixaController;
import services.AutenticaçãoService;
import services.FornecedorService;
import utils.TerminalUtils;

import models.Produto;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AutenticaçãoService authService = new AutenticaçãoService();
        ProdutoController produtoController = new ProdutoController();
        CaixaController caixaController = new CaixaController();
        
        // inicializando fornecedor
        FornecedorService fornecedor = new FornecedorService();
        String caminhoArquivo = "./data/produtosFornecedor.csv";
        fornecedor.carregarProdutos(caminhoArquivo);

        System.out.println("Bem-vindo ao Sistema de Supermercado!");

        System.out.print("Digite seu nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        if (authService.autenticarAdministrador(username, senha)) {
            System.out.println("Bem-vindo, Administrador!");
            
            while (true) {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Exibir produtos");
                System.out.println("2. Exibir fluxo de caixa");
                System.out.println("3. Requisitar produto");
                System.out.println("4. Remover produto");
                System.out.println("5. Atualizar preço de um produto");
                System.out.println("6. Sair");
                System.out.print("Opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                switch (opcao) {
                    case 1:
                        TerminalUtils.limparTerminal();
                        produtoController.listarProdutos();
                        break;
                    case 2:
                        TerminalUtils.limparTerminal();
                        caixaController.listarOperacaos();
                        break;
                    case 3:
                        fornecedor.exibirProdutos();
                        System.out.print("Digite o ID do produto: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer
                        System.out.print("Digite a quantidade: ");
                        int quantidade = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer
                        Produto produtoRequisitado = fornecedor.fornecerProduto(id, quantidade);
                        
                        // verificar se o produto já existe
                        if (produtoController.produtoExiste(id)) {
                            produtoController.atualizarEstoqueProduto(id, quantidade);
                            caixaController.adicionarOperacao(produtoRequisitado, "Compra");
                            System.out.println("Produto abastecido");
                        } else {
                            System.out.print("Digite a taxa de revenda para esse produto: ");
                            double taxa = scanner.nextDouble();
                            scanner.nextLine();
                            produtoController.adicionarProduto(produtoRequisitado, taxa);
                            caixaController.adicionarOperacao(produtoRequisitado, "Compra");
                            System.out.println("Produto adicionado com sucesso");
                        }
                        break;
                    case 4:
                        System.out.print("Digite o ID do produto a ser removido: ");
                        id = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer
                        produtoController.removerProduto(id);
                        break;
                    case 5:
                        System.out.print("Digite o ID do produto a ser atualizado: ");
                        id = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer
                        System.out.print("Digite o novo preço do produto: ");
                        double preco = scanner.nextDouble();
                        scanner.nextLine(); // Limpar o buffer
                        produtoController.atualizarPrecoProduto(id, preco);
                        break;
                    case 6:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }
            
        } else if (authService.autenticarCliente(username, senha)) {
            System.out.println("Bem-vindo, Cliente!");


        } else {
            System.out.println("Usuário ou senha inválidos.");
        }

        scanner.close();
    }
}

