package models;

import java.util.Date;
import java.util.List;

public class CupomFiscal {
    private int idCupom;
    private Date dataEmissao;
    private double valorTotal;
    private List<Produto> itens;

    public CupomFiscal(int idCupom, Date dataEmissao, List<Produto> itens) {
        this.idCupom = idCupom;
        this.dataEmissao = dataEmissao;
        this.itens = itens;
        this.valorTotal = calcularValorTotal();
    }

    public void emitirCupom() {
        System.out.println("Cupom fiscal emitido com sucesso. Valor Total: " + valorTotal);
    }

    public double calcularImpostos() {
        return valorTotal * 0.15;
    }

    private double calcularValorTotal() {
        return itens.stream().mapToDouble(Produto::getPreco).sum();
    }
}
