package services;

import interfaces.EstoqueControlavel;
import interfaces.Relatorio;
import models.Produto;

import java.util.ArrayList;
import java.util.List;

public class Estoque implements EstoqueControlavel, Relatorio {
    private List<Produto> listaProdutos = new ArrayList<>();

    @Override
    public void atualizarEstoque(Produto produto, int quantidade) {
        produto.quantidadeEmEstoque += quantidade;
        System.out.println("Estoque do produto " + produto.getNome() + " atualizado.");
    }

    @Override
    public List<Produto> consultarEstoque() {
        return listaProdutos;
    }

    @Override
    public String gerarRelatorio() {
        StringBuilder relatorio = new StringBuilder("Relatório de services.Estoque:\n");
        for (Produto produto : listaProdutos) {
            relatorio.append("Produto: ").append(produto.getNome()).append(", Quantidade em estoque: ").append(produto.getQuantidadeEmEstoque()).append("\n");
        }
        return relatorio.toString();
    }
}
