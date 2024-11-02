package models;

public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    public int quantidadeEmEstoque;

    public Produto(int codigo, String nome, double preco, int quantidadeEmEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void cadastrarProduto() {
        System.out.println("Produto " + nome + " cadastrado com sucesso.");
    }

    public void atualizarProduto(double preco, int quantidadeEmEstoque) {
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        System.out.println("Produto " + nome + " atualizado com sucesso.");
    }

    public void removerProduto() {
        System.out.println("Produto " + nome + " removido com sucesso.");
    }

    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }
    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

}
