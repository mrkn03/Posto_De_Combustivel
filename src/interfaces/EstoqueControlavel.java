package interfaces;

import models.Produto;

import java.util.List;

public interface EstoqueControlavel {
    void atualizarEstoque(Produto produto, int quantidade);
    List<Produto> consultarEstoque();
}
