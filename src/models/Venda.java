package models;

import interfaces.Relatorio;

import java.util.Date;
import java.util.List;

public class Venda implements Relatorio {
    private int idVenda;
    private Date data;
    private List<Produto> listaProdutos;
    private Funcionario funcionarioResponsavel;

    public Venda(int idVenda, Date data, List<Produto> listaProdutos, Funcionario funcionarioResponsavel) {
        this.idVenda = idVenda;
        this.data = data;
        this.listaProdutos = listaProdutos;
        this.funcionarioResponsavel = funcionarioResponsavel;
    }

    public void registrarVenda() {
        System.out.println("Venda registrada com sucesso pelo funcionário " + funcionarioResponsavel.getNome());
    }

    @Override
    public String gerarRelatorio() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório de models.Venda - ID: ").append(idVenda).append("\n");
        relatorio.append("Data: ").append(data).append("\n");
        for (Produto produto : listaProdutos) {
            relatorio.append("Produto: ").append(produto.getNome()).append(", Preço: ").append(produto.getPreco()).append("\n");
        }
        return relatorio.toString();
    }

    public String gerarRelatorioVendaPorPeriodo(Date dataInicio, Date dataFim) {
        // Simplificação da implementação
        return "Relatório de vendas do período de " + dataInicio + " a " + dataFim;
    }
}
