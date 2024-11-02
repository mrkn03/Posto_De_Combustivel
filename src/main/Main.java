package main;

import models.Fornecedor;
import models.Funcionario;
import models.Produto;
import models.Venda;
import services.Estoque;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static List<Produto> produtos = new ArrayList<>();
    private static List<Fornecedor> fornecedores = new ArrayList<>();
    private static List<Venda> vendas = new ArrayList<>();
    private static Estoque estoque = new Estoque();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n--- Sistema de Gestão de Posto de Combustível ---");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Cadastrar Produto");
            System.out.println("3. Cadastrar Fornecedor");
            System.out.println("4. Registrar Venda");
            System.out.println("5. Consultar Estoque");
            System.out.println("6. Gerar Relatório de Vendas");
            System.out.println("7. Gerar Relatório de Estoque");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    cadastrarProduto();
                    break;
                case 3:
                    cadastrarFornecedor();
                    break;
                case 4:
                    registrarVenda();
                    break;
                case 5:
                    consultarEstoque();
                    break;
                case 6:
                    gerarRelatorioVendas();
                    break;
                case 7:
                    gerarRelatorioEstoque();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void cadastrarFuncionario() {
        System.out.print("ID do Funcionário: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome do Funcionário: ");
        String nome = sc.nextLine();
        System.out.print("Cargo: ");
        String cargo = sc.nextLine();
        System.out.print("Salário: ");
        double salario = sc.nextDouble();

        Funcionario funcionario = new Funcionario(id, nome, cargo, salario);
        funcionario.cadastrarFuncionario();
        funcionarios.add(funcionario);
    }

    private static void cadastrarProduto() {
        System.out.print("Código do Produto: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome do Produto: ");
        String nome = sc.nextLine();
        System.out.print("Preço: ");
        double preco = sc.nextDouble();
        System.out.print("Quantidade em Estoque: ");
        int quantidade = sc.nextInt();

        Produto produto = new Produto(codigo, nome, preco, quantidade);
        produto.cadastrarProduto();
        produtos.add(produto);
        estoque.atualizarEstoque(produto, quantidade);
    }

    private static void cadastrarFornecedor() {
        System.out.print("ID do Fornecedor: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome do Fornecedor: ");
        String nome = sc.nextLine();
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        System.out.print("Contato: ");
        String contato = sc.nextLine();

        Fornecedor fornecedor = new Fornecedor(id, nome, endereco, contato);
        fornecedor.cadastrar();
        fornecedores.add(fornecedor);
    }

    private static void registrarVenda() {
        System.out.print("ID da Venda: ");
        int idVenda = sc.nextInt();
        sc.nextLine();
        System.out.print("ID do Funcionário responsável pela venda: ");
        int idFuncionario = sc.nextInt();

        Funcionario funcionario = funcionarios.stream().filter(f -> f.getId() == idFuncionario).findFirst().orElse(null);

        if (funcionario == null) {
            System.out.println("Funcionário não encontrado!");
            return;
        }

        List<Produto> itensVenda = new ArrayList<>();
        System.out.print("Número de produtos na venda: ");
        int numProdutos = sc.nextInt();

        for (int i = 0; i < numProdutos; i++) {
            System.out.print("Código do Produto: ");
            int codigoProduto = sc.nextInt();
            Produto produto = produtos.stream().filter(p -> p.getCodigo() == codigoProduto).findFirst().orElse(null);

            if (produto != null) {
                itensVenda.add(produto);
                estoque.atualizarEstoque(produto, -1);
            } else {
                System.out.println("Produto não encontrado!");
            }
        }

        Venda venda = new Venda(idVenda, new Date(), itensVenda, funcionario);
        venda.registrarVenda();
        vendas.add(venda);
    }

    private static void consultarEstoque() {
        List<Produto> listaEstoque = estoque.consultarEstoque();
        System.out.println("--- Estoque ---");
        for (Produto produto : listaEstoque) {
            System.out.println("Produto: " + produto.getNome() + ", Quantidade em estoque: " + produto.getQuantidadeEmEstoque());
        }
    }

    private static void gerarRelatorioVendas() {
        System.out.println("--- Relatório de Vendas ---");
        for (Venda venda : vendas) {
            System.out.println(venda.gerarRelatorio());
        }
    }

    private static void gerarRelatorioEstoque() {
        System.out.println(estoque.gerarRelatorio());
    }
}

