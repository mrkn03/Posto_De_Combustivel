package models;

import interfaces.EntidadeRegistravel;

public class Fornecedor extends EntidadeRegistravel {
    private int id;
    private String nome;
    private String endereco;
    private String contato;

    // Construtor
    public Fornecedor(int id, String nome, String endereco, String contato) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
    }

    @Override
    public void cadastrar() {
        System.out.println("Fornecedor " + nome + " cadastrado com sucesso.");
    }

    @Override
    public void atualizar() {
        System.out.println("Fornecedor " + nome + " atualizado com sucesso.");
    }

    @Override
    public void remover() {
        System.out.println("Fornecedor " + nome + " removido com sucesso.");
    }
}
