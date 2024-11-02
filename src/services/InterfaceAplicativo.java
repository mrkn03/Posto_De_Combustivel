package services;

public class InterfaceAplicativo {
    private String tema;
    private String idioma;

    public void iniciarInterface() {
        System.out.println("Interface iniciada com tema " + tema + " e idioma " + idioma);
    }

    public void mostrarTelaCadastroProduto() {
        System.out.println("Tela de cadastro de produto exibida.");
    }

    public void mostrarTelaCadastroFornecedor() {
        System.out.println("Tela de cadastro de fornecedor exibida.");
    }

    public void mostrarTelaCadastroFuncionario() {
        System.out.println("Tela de cadastro de funcionário exibida.");
    }

    public void mostrarTelaRegistroVenda() {
        System.out.println("Tela de registro de venda exibida.");
    }

    public void mostrarRelatorioVendas() {
        System.out.println("Relatório de vendas exibido.");
    }

    public void mostrarRelatorioEstoque() {
        System.out.println("Relatório de estoque exibido.");
    }
}
